package com.example.mvvm_demo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvm_demo.model.DataItem;

@Database(entities = {DataItem.class},version = 1)
public abstract class DataDatabase extends RoomDatabase {


    public abstract Datadao datadao();

    public static DataDatabase instance;
    public static DataDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context,DataDatabase.class,"DataDatabase")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

}
