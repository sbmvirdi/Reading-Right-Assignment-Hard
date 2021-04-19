package com.sbmvirdi.foodycookbook.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.sbmvirdi.foodycookbook.modelClasses.Meal;

@Database(entities = {Meal.class},exportSchema = false,version = 1)
public abstract class RoomDatabaseInstance extends RoomDatabase {

    public abstract MealDao mealDao();
    private static RoomDatabaseInstance instance;

    public static RoomDatabaseInstance getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDatabaseInstance.class,
                    "meal-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
