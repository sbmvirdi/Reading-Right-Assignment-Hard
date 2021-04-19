package com.sbmvirdi.foodycookbook.network;

import com.sbmvirdi.foodycookbook.modelClasses.MealData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealAPI {

    // endpoint to get a random meal
    @GET("random.php")
    Call<MealData> getRandomMeal();

    // endpoint to search meals by search keyword
    @GET("search.php")
    Call<MealData> getMealsBySearchQuery(@Query("s") String searchKeyword);

}
