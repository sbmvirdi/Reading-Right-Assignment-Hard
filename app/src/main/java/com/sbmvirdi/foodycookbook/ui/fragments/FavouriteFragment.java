package com.sbmvirdi.foodycookbook.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.adapters.SearchMealAdapter;
import com.sbmvirdi.foodycookbook.databinding.FragmentFavouriteBinding;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.ui.activities.MainActivity;
import com.sbmvirdi.foodycookbook.viewModels.FavouriteFragmentViewModel;

import java.util.List;

public class FavouriteFragment extends Fragment {

    FragmentFavouriteBinding fragmentFavouriteBinding;
    FavouriteFragmentViewModel viewModel;
    public FavouriteFragment() {
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
        fragmentFavouriteBinding = FragmentFavouriteBinding.inflate(LayoutInflater.from(getContext()));
        viewModel = new ViewModelProvider(this).get(FavouriteFragmentViewModel.class);
        viewModel.getFavouritesFromRoom(getContext());
        viewModel.getMeals().observe(getViewLifecycleOwner(),this::loadData);
        return fragmentFavouriteBinding.getRoot();
    }

    private void loadData(List<Meal> meals) {
        if (meals.size()>0) {
            fragmentFavouriteBinding.favouriteRecycler.setVisibility(View.VISIBLE);
            fragmentFavouriteBinding.empty.setVisibility(View.GONE);
            fragmentFavouriteBinding.favouriteRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavouriteBinding.favouriteRecycler.setAdapter(new SearchMealAdapter(meals, getContext(), meal -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("meal", meal);
                Navigation.findNavController(requireView()).navigate(R.id.action_favouriteFragment_to_detailedMealFragment, bundle);
            }));
        }else{
            fragmentFavouriteBinding.empty.setVisibility(View.VISIBLE);
            fragmentFavouriteBinding.favouriteRecycler.setVisibility(View.GONE);
        }
    }
}