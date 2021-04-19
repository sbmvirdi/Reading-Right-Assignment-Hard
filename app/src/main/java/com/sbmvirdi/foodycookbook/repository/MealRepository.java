package com.sbmvirdi.foodycookbook.repository;

import androidx.annotation.NonNull;
import com.sbmvirdi.foodycookbook.interfaces.LoadData;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.modelClasses.MealData;
import com.sbmvirdi.foodycookbook.network.MealAPI;
import com.sbmvirdi.foodycookbook.network.RetrofitInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {

    public static MealRepository instance;
    private static final String TAG = MealRepository.class.getSimpleName();

    public static MealRepository getInstance() {
        if (instance == null) {
            instance = new MealRepository();
        }

        return instance;
    }


    /**
     * function to get random meal from the REST API
     * @param loadData used to send back the data to caller
     */
    public void getRandomMeal(LoadData<List<Meal>> loadData){

        List<Meal> meals = new ArrayList<>();
        MealAPI api = RetrofitInstance.getInstance().create(MealAPI.class);
        Call<MealData> randomMealCall = api.getRandomMeal();
        randomMealCall.enqueue(new Callback<MealData>() {
            @Override
            public void onResponse(@NonNull Call<MealData> call, @NonNull Response<MealData> response) {
                if (response.isSuccessful()){
                    MealData mealData = response.body();
                    assert mealData != null;
                    if (mealData.getMeals()!=null) {
                        meals.addAll(mealData.getMeals());
                        loadData.onDataLoaded(meals);
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<MealData> call, @NonNull Throwable t) {
                loadData.onDataLoaded(new ArrayList<>());
            }
        });

    }

    /**
     * function to get list of meals from REST API by passing keyword
     * @param keyword query param for keyword
     * @param loadData used to send back the data to caller
     */
    public void getMealsByKeyword(String keyword,LoadData<List<Meal>> loadData){

        List<Meal> meals = new ArrayList<>();
        MealAPI api = RetrofitInstance.getInstance().create(MealAPI.class);
        Call<MealData> searchQuery = api.getMealsBySearchQuery(keyword);
        searchQuery.enqueue(new Callback<MealData>() {
            @Override
            public void onResponse(@NonNull Call<MealData> call, @NonNull Response<MealData> response) {
                if (response.isSuccessful()){
                    MealData mealData = response.body();
                    assert mealData != null;
                    if (mealData.getMeals()!=null) {
                        meals.addAll(mealData.getMeals());
                        loadData.onDataLoaded(meals);
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<MealData> call, @NonNull Throwable t) {
                loadData.onDataLoaded(new ArrayList<>());
            }
        });
    }
}
