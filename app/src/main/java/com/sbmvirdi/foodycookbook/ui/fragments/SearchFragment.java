package com.sbmvirdi.foodycookbook.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.adapters.SearchMealAdapter;
import com.sbmvirdi.foodycookbook.databinding.FragmentSearchBinding;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;
import com.sbmvirdi.foodycookbook.ui.activities.MainActivity;
import com.sbmvirdi.foodycookbook.viewModels.SearchFragmentViewModel;

import java.util.List;


public class SearchFragment extends Fragment {
    FragmentSearchBinding fragmentSearchBinding;
    SearchFragmentViewModel viewModel;


    public SearchFragment() {
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
        fragmentSearchBinding = FragmentSearchBinding.inflate(LayoutInflater.from(getContext()));
        viewModel = new ViewModelProvider(this).get(SearchFragmentViewModel.class);

        fragmentSearchBinding.searchButton.setOnClickListener(v->{
            if (!fragmentSearchBinding.searchBar.getText().toString().isEmpty()){
                viewModel.getSearchResult(fragmentSearchBinding.searchBar.getText().toString());
            }
        });

        viewModel.getMeals().observe(getViewLifecycleOwner(),this::initData);

        viewModel.getIsLoading().observe(getViewLifecycleOwner(),isLoading->{
            if (isLoading){
                fragmentSearchBinding.progress.setVisibility(View.VISIBLE);
            }else{
                fragmentSearchBinding.progress.setVisibility(View.GONE);
            }
        });

        return fragmentSearchBinding.getRoot();
    }

    private void initData(List<Meal> meals) {
        fragmentSearchBinding.searchRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentSearchBinding.searchRecycler.setAdapter(new SearchMealAdapter(meals,getContext(),meal->{
            Bundle bundle = new Bundle();
            bundle.putSerializable("meal",meal);
            Navigation.findNavController(requireView()).navigate(R.id.action_searchFragment2_to_detailedMealFragment,bundle);
        }));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.search).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }
}