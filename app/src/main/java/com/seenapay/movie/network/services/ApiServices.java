package com.seenapay.movie.network.services;


import com.seenapay.movie.network.Models.responses.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("reviews/all.json")
    Observable<MovieResponse> requestMovies(
            @Query("query") String query,
            @Query("api-key") String apiKey);

}
