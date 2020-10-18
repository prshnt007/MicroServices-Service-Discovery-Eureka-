package com.prshnt.microservice.ratingsdataservice.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prshnt.microservice.ratingsdataservice.model.Rating;
import com.prshnt.microservice.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingsResource {

	@RequestMapping("/{movieid}")
	public Rating getMovieInfoByMovie(@PathVariable("movieid") String movieId) {
		return new Rating(movieId, 5);
	}

	@RequestMapping("/user/{userId}")
	public UserRating getMovieInfoByUserId(@PathVariable("userId") String userId) {
		return new UserRating( Arrays.asList(new Rating("234", 5), new Rating("345", 4), new Rating("678", 5)));
	}

}
