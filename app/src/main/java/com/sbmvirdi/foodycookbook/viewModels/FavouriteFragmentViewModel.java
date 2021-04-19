package com.sbmvirdi.foodycookbook.viewModels;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.repository.MealRepository;

import java.util.List;

public class FavouriteFragmentViewModel extends ViewModel {

    LiveData<List<Meal>> meals = new MutableLiveData<>();
    MealRepository mRepo;
    public FavouriteFragmentViewModel(){
        mRepo = MealRepository.getInstance();
    }

    public void getFavouritesFromRoom(Context context){
        mRepo.loadMealsFromRoom(context,list->{
            meals = list;
        });
    }

    public LiveData<List<Meal>> getMeals() {
        return meals;
    }
}
