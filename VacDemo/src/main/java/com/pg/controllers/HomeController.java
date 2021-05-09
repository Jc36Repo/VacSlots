package com.pg.controllers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.pg.beans.Center;
import com.pg.beans.Centers;
import com.pg.beans.Session;
import com.pg.beans.SlotDetails;

@Controller
public class HomeController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	//https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByDistrict?district_id=294&date=08-05-2021
	//String DISPLAY_API = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=294&date=07-05-2021";
	//String DISPLAY_API = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict";
	String DISPLAY_API = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict";
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type","application/json");
		headers.set("Accept-Language", "en-US");
		headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		
		//Get today's date and pass it to API
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		LocalDateTime now = LocalDateTime.now();
		String today = dtf.format(now);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(DISPLAY_API)
															.queryParam("district_id", "294")
															.queryParam("date", today);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		//HttpEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		//System.out.println("Api called");
		HttpEntity<Centers> vacresult = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Centers.class);
		
		Centers centers = vacresult.getBody();
		List<Center> centerList = centers.getCenters();
		//System.out.println(centerList.size());
		
		//Get Date formatter
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		
		List<SlotDetails> slotList = new ArrayList<>();
		for(Center c:centerList) {
			
			List<Session> sessions = c.getSessions();
			for(Session s:sessions) {
				
				if(s.getMin_age_limit()==18) {
					System.out.println("-----------------------------------");
					LocalDateTime nowTime = LocalDateTime.now();
					System.out.println("Data fetched at: "+dateTime.format(nowTime));
					SlotDetails slot = new SlotDetails(c.getName(), s.getAvailable_capacity(), c.getPincode(), s.getDate());
					slotList.add(slot);
					System.out.println("Name: " + c.getName() +" Available: " + s.getAvailable_capacity()+" Fee type: "+c.getFee_type());
					
				}
			}
		}
		model.addAttribute("slotList", slotList);
		
		return "main/home";
	}

}
