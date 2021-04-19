package com.sbmvirdi.foodycookbook.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.databinding.ActivityMainBinding;
import com.sbmvirdi.foodycookbook.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private static final String TAG = MainActivity.class.getSimpleName();
    AppBarConfiguration appBarConfiguration;
    NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        getSupportFragmentManager().beginTransaction().add(new HomeFragment(), null).commit();
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(activityMainBinding.mainFragmentContainer.getId());
        if (navHostFragment != null) {
            controller = navHostFragment.getNavController();
            appBarConfiguration = new AppBarConfiguration.Builder(controller.getGraph()).build();
            NavigationUI.setupActionBarWithNavController(this, controller
                    , appBarConfiguration);
        }

    }
}