package com.prshnt.microservice.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prshnt.microservice.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@RequestMapping("/{movieid}")
	public Movie getMovieInfo(@PathVariable("movieid") String movieId) {
		System.out.println(movieId);
		return new Movie(movieId ,"UP");
	}

}
