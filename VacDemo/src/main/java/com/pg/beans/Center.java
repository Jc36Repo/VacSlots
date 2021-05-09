package com.pg.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Center {
	
	private String center_id;
	private String name;
	private String address;
	private String state_name;
	private String district_name;
	private String block_name;
	private String pincode;
	private int lat;
	
	@JsonProperty("long")
	private int lon;
	
	@JsonProperty("from")
	private String fromdate;
	
	@JsonProperty("to")
	private String todate;
	
	private String fee_type;
	private List<Session> sessions;
	
	public Center() {
		
	}
	
	public Center(String center_id, String name, String address, String state_name, String district_name,
			String block_name, String pincode, int lat, int lon, String fromdate, String todate, String fee_type,
			List<Session> sessions) {
		super();
		this.center_id = center_id;
		this.name = name;
		this.address = address;
		this.state_name = state_name;
		this.district_name = district_name;
		this.block_name = block_name;
		this.pincode = pincode;
		this.lat = lat;
		this.lon = lon;
		this.fromdate = fromdate;
		this.todate = todate;
		this.fee_type = fee_type;
		this.sessions = sessions;
	}

	public String getCenter_id() {
		return center_id;
	}

	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLon() {
		return lon;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
	

}
