package com.example.todoapplic;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, exportSchema = false, version = 1)
abstract class TheDatabase extends RoomDatabase {
    abstract UserDao getUserDao();

    private static volatile TheDatabase instance;
    static TheDatabase getInstance(Context context) {
        if (instance==null) {
            instance= Room.databaseBuilder(context,TheDatabase.class,"the_database.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}