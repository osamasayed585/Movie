package com.seenapay.movie.repository;


import com.seenapay.movie.network.Models.requests.MoviesRequest;
import com.seenapay.movie.network.Models.responses.MovieResponse;
import com.seenapay.movie.network.services.ApiServices;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.Observable;

@ViewModelScoped
public class Repository {

    private final ApiServices apiServices;

    @Inject
    public Repository(ApiServices apiInterface) {
        this.apiServices = apiInterface;
    }

    public Observable<MovieResponse> requestMovies(MoviesRequest moviesRequest) {
        return apiServices.requestMovies(moviesRequest.getQuery(), moviesRequest.getApiKey());
    }
}