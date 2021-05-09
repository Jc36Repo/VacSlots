package com.pg.beans;

import java.util.ArrayList;
import java.util.List;

public class Centers {
	
	private List<Center> centers;
	
	public Centers() {
		centers = new ArrayList<>();
	}

	public Centers(List<Center> centers) {
		super();
		this.centers = centers;
	}

	public List<Center> getCenters() {
		return centers;
	}

	public void setCenters(List<Center> centers) {
		this.centers = centers;
	}
	
	

}
