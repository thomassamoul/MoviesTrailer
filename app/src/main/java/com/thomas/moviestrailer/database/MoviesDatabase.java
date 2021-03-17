package com.thomas.moviestrailer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.database.DAOs.MoviesDAO;

@Database(entities = {MovieDetail.class}, version = 1, exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "moviesDatabase";
    private static MoviesDatabase database;

    public abstract MoviesDAO moviesDAO();

    public static MoviesDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, MoviesDatabase.class, DATABASE_NAME).build();
        }
        return database;
    }

}