package com.sbmvirdi.foodycookbook.modelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealData {

    @SerializedName("meals")
    public List<Meal> meals;

    public List<Meal> getMeals() {
        return meals;
    }
}
