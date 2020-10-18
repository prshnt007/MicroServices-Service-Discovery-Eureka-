package com.prshnt.microservice.moviescatalogservice.model;

import java.util.List;

public class UserRatings {
	
	List<Rating> userRatings ;

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRatings(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	

}
