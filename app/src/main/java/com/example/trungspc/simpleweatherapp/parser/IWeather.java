package com.example.trungspc.simpleweatherapp.parser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeather {
    @GET("forecast")
    Call<WeatherResponse> getWeather(
        @Query("id") int id,
        @Query("units") String unit,
        @Query("lang") String language,
        @Query("APPID") String key
    );
}
