package com.sbmvirdi.foodycookbook.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(LayoutInflater.from(getContext()));
        return homeBinding.getRoot();
    }
}