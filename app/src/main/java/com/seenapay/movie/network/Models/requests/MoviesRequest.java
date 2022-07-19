package com.seenapay.movie.network.Models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class MoviesRequest {

    private String query;
    private String apiKey;

}
