package com.seenapay.movie.network.Models.responses;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    /**

      message : ok
      success : false

     */

    @SerializedName("status")
    private String message;

    @SerializedName("has_more")
    private boolean success;

    @SerializedName("num_results")
    private int countResponse;

    private String copyright;


}
