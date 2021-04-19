package com.sbmvirdi.foodycookbook.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment {
    FragmentSearchBinding fragmentSearchBinding;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         fragmentSearchBinding = FragmentSearchBinding.inflate(LayoutInflater.from(getContext()));

        return fragmentSearchBinding.getRoot();
    }
}