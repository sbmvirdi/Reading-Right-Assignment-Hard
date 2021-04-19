package com.sbmvirdi.foodycookbook.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.Utils;
import com.sbmvirdi.foodycookbook.databinding.FragmentHomeBinding;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.room.RoomDatabaseInstance;
import com.sbmvirdi.foodycookbook.ui.activities.MainActivity;
import com.sbmvirdi.foodycookbook.viewModels.HomeFragmentViewModel;
import com.stephenvinouze.linkifiedtextview.LinkTextView;

import java.util.List;


public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;
    HomeFragmentViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.showSearch();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(LayoutInflater.from(getContext()));
        viewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        viewModel.getRandomMeal();
        viewModel.getMeal().observe(getViewLifecycleOwner(), this::setMealData);

        viewModel.getIsLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading) {
                homeBinding.meal.mealRow.setVisibility(View.GONE);
                homeBinding.progress.setVisibility(View.VISIBLE);
            } else {
                homeBinding.progress.setVisibility(View.GONE);
                homeBinding.meal.mealRow.setVisibility(View.VISIBLE);
            }
        });
        return homeBinding.getRoot();
    }

    private void setMealData(Meal meal) {

        if (RoomDatabaseInstance.getAppDatabase(getContext()).mealDao().getMealById(meal.getIdMeal())!=null){
            bookmarkMeal();
        }else{
            removeBookmark();
        }


        homeBinding.bookmarkStatus.setOnClickListener(v->{
            if (RoomDatabaseInstance.getAppDatabase(getContext()).mealDao().getMealById(meal.getIdMeal())!=null){
                // already in database remove it
                RoomDatabaseInstance.getAppDatabase(getContext()).mealDao().deleteMealById(meal.getIdMeal());
                // remove bookmark after it is deleted
                removeBookmark();
            }else{
                // it is not bookmarked
                RoomDatabaseInstance.getAppDatabase(getContext()).mealDao().insertMeal(meal);
                bookmarkMeal();
            }
        });

        Glide.with(homeBinding.getRoot()).load(meal.getStrMealThumb()).into(homeBinding.meal.strMealThumb);
        homeBinding.meal.strMeal.setText(meal.getStrMeal());
        homeBinding.meal.strCategory.setText(meal.getStrCategory());
        homeBinding.meal.strArea.setText(meal.getStrArea());
        homeBinding.meal.strInstructions.setText(meal.getStrInstructions());

        if (meal.getStrTags() != null) {
            if (!meal.getStrTags().equals("")) {
                String[] tags = meal.getStrTags().split(",");
                homeBinding.meal.strTags.setTags(tags);
            }
        }

        if (meal.getStrIngredient1()!=null) {
            if (!meal.getStrIngredient1().equals("")) {
                homeBinding.meal.strIngredient1.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure1.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient1.setText(String.format("%s:", meal.getStrIngredient1()));
                homeBinding.meal.strMeasure1.setText(meal.getStrMeasure1());
            }
        }

        if (meal.getStrIngredient2()!=null) {
            if (!meal.getStrIngredient2().equals("")) {
                homeBinding.meal.strIngredient2.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure2.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient2.setText(String.format("%s:", meal.getStrIngredient2()));
                homeBinding.meal.strMeasure2.setText(meal.getStrMeasure2());
            }
        }

        if (meal.getStrIngredient3()!=null) {
            if (!meal.getStrIngredient3().equals("")) {
                homeBinding.meal.strIngredient3.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure3.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient3.setText(String.format("%s:", meal.getStrIngredient3()));
                homeBinding.meal.strMeasure3.setText(meal.getStrMeasure3());
            }
        }

        if (meal.getStrIngredient4()!=null) {
            if (!meal.getStrIngredient4().equals("")) {
                homeBinding.meal.strIngredient4.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure4.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient4.setText(String.format("%s:", meal.getStrIngredient4()));
                homeBinding.meal.strMeasure4.setText(meal.getStrMeasure4());
            }
        }

        if (meal.getStrIngredient5()!=null) {
            if (!meal.getStrIngredient5().equals("")) {
                homeBinding.meal.strIngredient5.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure5.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient5.setText(String.format("%s:", meal.getStrIngredient5()));
                homeBinding.meal.strMeasure5.setText(meal.getStrMeasure5());
            }
        }

        if (meal.getStrIngredient6()!=null) {
            if (!meal.getStrIngredient6().equals("")) {
                homeBinding.meal.strIngredient6.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure6.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient6.setText(String.format("%s:", meal.getStrIngredient6()));
                homeBinding.meal.strMeasure6.setText(meal.getStrMeasure6());
            }
        }

        if (meal.getStrIngredient7()!=null) {
            if (!meal.getStrIngredient7().equals("")) {
                homeBinding.meal.strIngredient7.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure7.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient7.setText(String.format("%s:", meal.getStrIngredient7()));
                homeBinding.meal.strMeasure7.setText(meal.getStrMeasure7());
            }
        }

        if (meal.getStrIngredient8()!=null) {
            if (!meal.getStrIngredient8().equals("")) {
                homeBinding.meal.strIngredient8.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure8.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient8.setText(String.format("%s:", meal.getStrIngredient8()));
                homeBinding.meal.strMeasure8.setText(meal.getStrMeasure8());
            }
        }

        if (meal.getStrIngredient9()!=null) {
            if (!meal.getStrIngredient9().equals("")) {
                homeBinding.meal.strIngredient9.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure9.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient9.setText(String.format("%s:", meal.getStrIngredient9()));
                homeBinding.meal.strMeasure9.setText(meal.getStrMeasure9());
            }
        }

        if (meal.getStrIngredient10()!=null) {
            if (!meal.getStrIngredient10().equals("")) {
                homeBinding.meal.strIngredient10.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure10.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient10.setText(String.format("%s:", meal.getStrIngredient10()));
                homeBinding.meal.strMeasure10.setText(meal.getStrMeasure10());
            }
        }

        if (meal.getStrIngredient11()!=null) {
            if (!meal.getStrIngredient11().equals("")) {
                homeBinding.meal.strIngredient11.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure11.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient11.setText(String.format("%s:", meal.getStrIngredient11()));
                homeBinding.meal.strMeasure11.setText(meal.getStrMeasure11());
            }
        }

        if (meal.getStrIngredient12()!=null) {
            if (!meal.getStrIngredient12().equals("")) {
                homeBinding.meal.strIngredient12.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure12.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient12.setText(String.format("%s:", meal.getStrIngredient12()));
                homeBinding.meal.strMeasure12.setText(meal.getStrMeasure12());
            }
        }

        if (meal.getStrIngredient13()!=null) {
            if (!meal.getStrIngredient13().equals("")) {
                homeBinding.meal.strIngredient13.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure13.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient13.setText(String.format("%s:", meal.getStrIngredient13()));
                homeBinding.meal.strMeasure13.setText(meal.getStrMeasure13());
            }
        }

        if (meal.getStrIngredient14()!=null) {
            if (!meal.getStrIngredient14().equals("")) {
                homeBinding.meal.strIngredient14.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure14.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient14.setText(String.format("%s:", meal.getStrIngredient14()));
                homeBinding.meal.strMeasure14.setText(meal.getStrMeasure14());
            }
        }

        if (meal.getStrIngredient15()!=null) {
            if (!meal.getStrIngredient15().equals("")) {
                homeBinding.meal.strIngredient15.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure15.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient15.setText(String.format("%s:", meal.getStrIngredient15()));
                homeBinding.meal.strMeasure15.setText(meal.getStrMeasure15());
            }
        }

        if (meal.getStrIngredient16()!=null) {
            if (!meal.getStrIngredient16().equals("")) {
                homeBinding.meal.strIngredient16.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure16.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient16.setText(String.format("%s:", meal.getStrIngredient16()));
                homeBinding.meal.strMeasure16.setText(meal.getStrMeasure16());
            }
        }

        if (meal.getStrIngredient17()!=null) {
            if (!meal.getStrIngredient17().equals("")) {
                homeBinding.meal.strIngredient17.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure17.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient17.setText(String.format("%s:", meal.getStrIngredient17()));
                homeBinding.meal.strMeasure17.setText(meal.getStrMeasure17());
            }
        }

        if (meal.getStrIngredient18()!=null) {
            if (!meal.getStrIngredient18().equals("")) {
                homeBinding.meal.strIngredient18.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure18.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient18.setText(String.format("%s:", meal.getStrIngredient18()));
                homeBinding.meal.strMeasure18.setText(meal.getStrMeasure18());
            }
        }

        if (meal.getStrIngredient19()!=null) {
            if (!meal.getStrIngredient19().equals("")) {
                homeBinding.meal.strIngredient19.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure19.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient19.setText(String.format("%s:", meal.getStrIngredient19()));
                homeBinding.meal.strMeasure19.setText(meal.getStrMeasure19());
            }
        }

        if (meal.getStrIngredient20()!=null) {
            if (!meal.getStrIngredient20().equals("")) {
                homeBinding.meal.strIngredient20.setVisibility(View.VISIBLE);
                homeBinding.meal.strMeasure20.setVisibility(View.VISIBLE);
                homeBinding.meal.strIngredient20.setText(String.format("%s:", meal.getStrIngredient20()));
                homeBinding.meal.strMeasure20.setText(meal.getStrMeasure20());
            }
        }

        if (meal.getStrSource() != null) {
            homeBinding.meal.strSource.setLinksClickable(true);
            homeBinding.meal.strSource.setLinkText(meal.getStrSource());
            homeBinding.meal.strSource.setOnLinkClickListener((view, s, i) -> {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(meal.getStrSource()));
                startActivity(browserIntent);
            });
        }


        if (meal.getStrYoutube()!=null) {
            if (!meal.getStrYoutube().equals("")) {
                homeBinding.meal.playYoutube.setVisibility(View.VISIBLE);
                homeBinding.meal.playYoutube.setOnClickListener(v -> {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(meal.getStrYoutube()));
                    try {
                        startActivity(webIntent);
                    } catch (ActivityNotFoundException ex) {
                        Log.e("youtube", "setMealData: " + ex.getLocalizedMessage());
                    }
                });

            }
        }

    }

    private void removeBookmark(){
        Glide.with(homeBinding.getRoot()).load(R.drawable.ic_bookmark).into(homeBinding.bookmarkStatus);
    }

    private void bookmarkMeal(){
        Glide.with(homeBinding.getRoot()).load(R.drawable.ic_bookmarked).into(homeBinding.bookmarkStatus);
    }
}