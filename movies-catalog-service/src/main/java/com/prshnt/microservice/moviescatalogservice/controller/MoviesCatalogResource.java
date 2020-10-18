package com.prshnt.microservice.moviescatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.prshnt.microservice.moviescatalogservice.model.CatalogItem;
import com.prshnt.microservice.moviescatalogservice.model.Movie;
import com.prshnt.microservice.moviescatalogservice.model.UserRatings;

@RestController
@RequestMapping("/Catalog")
public class MoviesCatalogResource {
	@Autowired
	RestTemplate restTemplate; 
	
	@Autowired
	WebClient.Builder webClientbuilder;
	
	@Value("${rating.service.url}")
	private String ratingsDataUrl;
	
	@Value("${movie.service.url}")
	private String movieInfoUrl;
	
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userId) {
		UserRatings userRatings = webClientbuilder.build()
		.get()
		.uri(ratingsDataUrl+userId)
		.retrieve().bodyToMono(UserRatings.class)
		.block();
		
		return userRatings.getUserRatings().stream().map(rating ->{
			Movie movie = webClientbuilder.build()
			.get()
			.uri(movieInfoUrl+rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
		return	new CatalogItem(movie.getMovieName(),"OLD MEN",rating.getMovieRating());
		})
		.collect(Collectors.toList());
	}
	
	//Using Restemplates
	//Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
	//List<Rating> userRatings =  (List<Rating>) restTemplate.getForObject("http://localhost:8082/ratingdata/"+userId, UserRatings.class);
}
