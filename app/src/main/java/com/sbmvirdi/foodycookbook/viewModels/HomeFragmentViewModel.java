package com.sbmvirdi.foodycookbook.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.repository.MealRepository;

public class HomeFragmentViewModel extends ViewModel {

    public MutableLiveData<Meal> meal = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MealRepository mRepo;

    public HomeFragmentViewModel(){
        mRepo = MealRepository.getInstance();
    }

    public void getRandomMeal(){
        isLoading.setValue(true);
        mRepo.getRandomMeal(list->{
            if (list.size()>0){
                meal.setValue(list.get(0));
            }
            isLoading.setValue(false);
        });
    }

    public LiveData<Meal> getMeal() {
        return meal;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
