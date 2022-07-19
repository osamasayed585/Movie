package com.seenapay.movie.network.Models.responses;


import com.seenapay.movie.network.Models.beans.Movie;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieResponse extends BaseResponse {
    private List<Movie> results;
}
