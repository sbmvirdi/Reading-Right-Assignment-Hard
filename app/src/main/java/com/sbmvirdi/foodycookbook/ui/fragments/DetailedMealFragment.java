package com.sbmvirdi.foodycookbook.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.databinding.FragmentDetailedMealBinding;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.room.RoomDatabaseInstance;
import com.sbmvirdi.foodycookbook.ui.activities.MainActivity;

public class DetailedMealFragment extends Fragment {

    FragmentDetailedMealBinding detailedMealBinding;
    Meal meal;
    public DetailedMealFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.hideSearch();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        detailedMealBinding = FragmentDetailedMealBinding.inflate(LayoutInflater.from(getContext()));

        return detailedMealBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!=null){
            meal = (Meal) getArguments().getSerializable("meal");
            setMealData(meal);
            if (RoomDatabaseInstance.getAppDatabase(getContext()).mealDao().getMealById(meal.getIdMeal())!=null){
                bookmarkMeal();
            }else{
                removeBookmark();
            }

            detailedMealBinding.bookmarkStatus.setOnClickListener(v->{
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
        }
    }

    private void removeBookmark(){
        Glide.with(detailedMealBinding.getRoot()).load(R.drawable.ic_bookmark).into(detailedMealBinding.bookmarkStatus);
    }

    private void bookmarkMeal(){
        Glide.with(detailedMealBinding.getRoot()).load(R.drawable.ic_bookmarked).into(detailedMealBinding.bookmarkStatus);
    }

    private void setMealData(Meal meal) {


        Glide.with(detailedMealBinding.getRoot()).load(meal.getStrMealThumb()).into(detailedMealBinding.meal.strMealThumb);
        detailedMealBinding.meal.strMeal.setText(meal.getStrMeal());
        detailedMealBinding.meal.strCategory.setText(meal.getStrCategory());
        detailedMealBinding.meal.strArea.setText(meal.getStrArea());
        detailedMealBinding.meal.strInstructions.setText(meal.getStrInstructions());

        if (meal.getStrTags() != null) {
            if (!meal.getStrTags().equals("")) {
                String[] tags = meal.getStrTags().split(",");
                detailedMealBinding.meal.strTags.setTags(tags);
            }
        }

        if (meal.getStrIngredient1()!=null) {
            if (!meal.getStrIngredient1().equals("")) {
                detailedMealBinding.meal.strIngredient1.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure1.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient1.setText(String.format("%s:", meal.getStrIngredient1()));
                detailedMealBinding.meal.strMeasure1.setText(meal.getStrMeasure1());
            }
        }

        if (meal.getStrIngredient2()!=null) {
            if (!meal.getStrIngredient2().equals("")) {
                detailedMealBinding.meal.strIngredient2.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure2.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient2.setText(String.format("%s:", meal.getStrIngredient2()));
                detailedMealBinding.meal.strMeasure2.setText(meal.getStrMeasure2());
            }
        }

        if (meal.getStrIngredient3()!=null) {
            if (!meal.getStrIngredient3().equals("")) {
                detailedMealBinding.meal.strIngredient3.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure3.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient3.setText(String.format("%s:", meal.getStrIngredient3()));
                detailedMealBinding.meal.strMeasure3.setText(meal.getStrMeasure3());
            }
        }

        if (meal.getStrIngredient4()!=null) {
            if (!meal.getStrIngredient4().equals("")) {
                detailedMealBinding.meal.strIngredient4.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure4.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient4.setText(String.format("%s:", meal.getStrIngredient4()));
                detailedMealBinding.meal.strMeasure4.setText(meal.getStrMeasure4());
            }
        }

        if (meal.getStrIngredient5()!=null) {
            if (!meal.getStrIngredient5().equals("")) {
                detailedMealBinding.meal.strIngredient5.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure5.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient5.setText(String.format("%s:", meal.getStrIngredient5()));
                detailedMealBinding.meal.strMeasure5.setText(meal.getStrMeasure5());
            }
        }

        if (meal.getStrIngredient6()!=null) {
            if (!meal.getStrIngredient6().equals("")) {
                detailedMealBinding.meal.strIngredient6.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure6.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient6.setText(String.format("%s:", meal.getStrIngredient6()));
                detailedMealBinding.meal.strMeasure6.setText(meal.getStrMeasure6());
            }
        }

        if (meal.getStrIngredient7()!=null) {
            if (!meal.getStrIngredient7().equals("")) {
                detailedMealBinding.meal.strIngredient7.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure7.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient7.setText(String.format("%s:", meal.getStrIngredient7()));
                detailedMealBinding.meal.strMeasure7.setText(meal.getStrMeasure7());
            }
        }

        if (meal.getStrIngredient8()!=null) {
            if (!meal.getStrIngredient8().equals("")) {
                detailedMealBinding.meal.strIngredient8.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure8.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient8.setText(String.format("%s:", meal.getStrIngredient8()));
                detailedMealBinding.meal.strMeasure8.setText(meal.getStrMeasure8());
            }
        }

        if (meal.getStrIngredient9()!=null) {
            if (!meal.getStrIngredient9().equals("")) {
                detailedMealBinding.meal.strIngredient9.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure9.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient9.setText(String.format("%s:", meal.getStrIngredient9()));
                detailedMealBinding.meal.strMeasure9.setText(meal.getStrMeasure9());
            }
        }

        if (meal.getStrIngredient10()!=null) {
            if (!meal.getStrIngredient10().equals("")) {
                detailedMealBinding.meal.strIngredient10.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure10.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient10.setText(String.format("%s:", meal.getStrIngredient10()));
                detailedMealBinding.meal.strMeasure10.setText(meal.getStrMeasure10());
            }
        }

        if (meal.getStrIngredient11()!=null) {
            if (!meal.getStrIngredient11().equals("")) {
                detailedMealBinding.meal.strIngredient11.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure11.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient11.setText(String.format("%s:", meal.getStrIngredient11()));
                detailedMealBinding.meal.strMeasure11.setText(meal.getStrMeasure11());
            }
        }

        if (meal.getStrIngredient12()!=null) {
            if (!meal.getStrIngredient12().equals("")) {
                detailedMealBinding.meal.strIngredient12.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure12.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient12.setText(String.format("%s:", meal.getStrIngredient12()));
                detailedMealBinding.meal.strMeasure12.setText(meal.getStrMeasure12());
            }
        }

        if (meal.getStrIngredient13()!=null) {
            if (!meal.getStrIngredient13().equals("")) {
                detailedMealBinding.meal.strIngredient13.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure13.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient13.setText(String.format("%s:", meal.getStrIngredient13()));
                detailedMealBinding.meal.strMeasure13.setText(meal.getStrMeasure13());
            }
        }

        if (meal.getStrIngredient14()!=null) {
            if (!meal.getStrIngredient14().equals("")) {
                detailedMealBinding.meal.strIngredient14.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure14.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient14.setText(String.format("%s:", meal.getStrIngredient14()));
                detailedMealBinding.meal.strMeasure14.setText(meal.getStrMeasure14());
            }
        }

        if (meal.getStrIngredient15()!=null) {
            if (!meal.getStrIngredient15().equals("")) {
                detailedMealBinding.meal.strIngredient15.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure15.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient15.setText(String.format("%s:", meal.getStrIngredient15()));
                detailedMealBinding.meal.strMeasure15.setText(meal.getStrMeasure15());
            }
        }

        if (meal.getStrIngredient16()!=null) {
            if (!meal.getStrIngredient16().equals("")) {
                detailedMealBinding.meal.strIngredient16.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure16.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient16.setText(String.format("%s:", meal.getStrIngredient16()));
                detailedMealBinding.meal.strMeasure16.setText(meal.getStrMeasure16());
            }
        }

        if (meal.getStrIngredient17()!=null) {
            if (!meal.getStrIngredient17().equals("")) {
                detailedMealBinding.meal.strIngredient17.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure17.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient17.setText(String.format("%s:", meal.getStrIngredient17()));
                detailedMealBinding.meal.strMeasure17.setText(meal.getStrMeasure17());
            }
        }

        if (meal.getStrIngredient18()!=null) {
            if (!meal.getStrIngredient18().equals("")) {
                detailedMealBinding.meal.strIngredient18.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure18.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient18.setText(String.format("%s:", meal.getStrIngredient18()));
                detailedMealBinding.meal.strMeasure18.setText(meal.getStrMeasure18());
            }
        }

        if (meal.getStrIngredient19()!=null) {
            if (!meal.getStrIngredient19().equals("")) {
                detailedMealBinding.meal.strIngredient19.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure19.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient19.setText(String.format("%s:", meal.getStrIngredient19()));
                detailedMealBinding.meal.strMeasure19.setText(meal.getStrMeasure19());
            }
        }

        if (meal.getStrIngredient20()!=null) {
            if (!meal.getStrIngredient20().equals("")) {
                detailedMealBinding.meal.strIngredient20.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strMeasure20.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.strIngredient20.setText(String.format("%s:", meal.getStrIngredient20()));
                detailedMealBinding.meal.strMeasure20.setText(meal.getStrMeasure20());
            }
        }

        if (meal.getStrSource() != null) {
            detailedMealBinding.meal.strSource.setLinksClickable(true);
            detailedMealBinding.meal.strSource.setLinkText(meal.getStrSource());
            detailedMealBinding.meal.strSource.setOnLinkClickListener((view, s, i) -> {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(meal.getStrSource()));
                startActivity(browserIntent);
            });
        }


        if (meal.getStrYoutube()!=null) {
            if (!meal.getStrYoutube().equals("")) {
                detailedMealBinding.meal.playYoutube.setVisibility(View.VISIBLE);
                detailedMealBinding.meal.playYoutube.setOnClickListener(v -> {
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
}