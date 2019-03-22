package com.example.moviessearchengine.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.moviessearchengine.utils.Constants;

@Database(entities = {MovieEntity.class} , version = 1 )
public abstract class MovieRoomDatabase extends RoomDatabase {
    abstract MovieDao getMovieDao();

    private static volatile MovieRoomDatabase INSTANCE ;

    static MovieRoomDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (MovieRoomDatabase.class){
             if (INSTANCE == null){
                 INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                         MovieRoomDatabase.class, Constants.DATABASE_NAME)
                         .build();
             }
            }
        }

        return INSTANCE;
    }

}
