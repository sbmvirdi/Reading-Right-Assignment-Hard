package com.sbmvirdi.foodycookbook.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.repository.MealRepository;

import java.util.List;

public class SearchFragmentViewModel extends ViewModel {

    MutableLiveData<List<Meal>> meals = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    MealRepository mRepo;

    public SearchFragmentViewModel(){
        mRepo = MealRepository.getInstance();
    }

    public void getSearchResult(String keyword){
        isLoading.setValue(true);
        mRepo.getMealsByKeyword(keyword,list->{
            meals.setValue(list);
            isLoading.setValue(false);
        });
    }

    public LiveData<List<Meal>> getMeals() {
        return meals;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
