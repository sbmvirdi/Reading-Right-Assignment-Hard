package com.sbmvirdi.foodycookbook.modelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomMeal {

    @SerializedName("meals")
    public List<Meal> meals = null;
}
