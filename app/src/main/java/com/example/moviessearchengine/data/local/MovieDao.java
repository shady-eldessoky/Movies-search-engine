package com.example.moviessearchengine.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie_table")
    List<MovieEntity> getMovies();
}
