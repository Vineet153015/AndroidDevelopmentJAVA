package com.example.movieapp.serviceApi;

import com.example.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

//    The Service Interface defines the Structure
//    and behaviour of the API requests.
//    Acts as the bridge between your app and API

    @GET("movie/popular")  // define your endpoint
    Call<Result> getPopularMovies(@Query("api_key") String apikey);
}
