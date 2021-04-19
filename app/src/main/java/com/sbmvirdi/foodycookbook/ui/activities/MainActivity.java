package com.sbmvirdi.foodycookbook.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.sbmvirdi.foodycookbook.R;
import com.sbmvirdi.foodycookbook.databinding.ActivityMainBinding;
import com.sbmvirdi.foodycookbook.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private static final String TAG = MainActivity.class.getSimpleName();
    AppBarConfiguration appBarConfiguration;
    NavController controller;
    static Menu menu;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search){
            if (controller != null) {
                controller.navigate(R.id.action_homeFragment_to_searchFragment2);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (controller != null && appBarConfiguration != null)
            return NavigationUI.navigateUp(controller, appBarConfiguration)
                    || super.onSupportNavigateUp();
        else return super.onSupportNavigateUp();
    }

    public static void hideSearch(){
        if (menu!=null) {
            menu.findItem(R.id.search).setVisible(false);
        }
    }

    public static void showSearch(){
        if (menu!=null) {
            menu.findItem(R.id.search).setVisible(true);
        }

    }

}