package com.sbmvirdi.foodycookbook.repository;

public class MealRepository {
    public static MealRepository instance;
    private static final String TAG = MealRepository.class.getSimpleName();

    public static MealRepository getInstance() {
        if (instance == null) {
            instance = new MealRepository();
        }

        return instance;
    }
}
