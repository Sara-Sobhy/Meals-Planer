package com.example.meals.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealService {
    @GET("search.php?f=a")
    public Call<MealResponse> getAllProducts();



    /*
    @GET("random.php")
    public Call<MealResponse> getAllProducts();

     */
}
