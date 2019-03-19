package com.example.moviessearchengine.data.remote;

import com.example.moviessearchengine.data.remote.models.MainResponse;
import com.example.moviessearchengine.data.remote.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YtsApiServices {

    /**
     * @return Used to list all the available movies
     */
    @GET("list_movies.json")
    Call<MainResponse> getData();

    /**
     * @param sort_by Sorts the results by choosen value
     * @param limit   The limit of results per page that has been set
     * @param page    Used to see the next page of movies, eg limit=15 and page=2 will show you movies 15-30
     * @param quality Used to filter by a given quality
     * @return search through out all the available movies. Can sort, filter, search and order the results
     */
    @GET("list_movies.json")
    Call<MainResponse> getSortedData(@Query("sort_by") String sort_by,
                                     @Query("limit") int limit,
                                     @Query("page") int page,
                                     @Query("quality") String quality);

    /**
     * @param query_term Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     * @return list of all the available movies
     */
    @GET("list_movies.json")
    Call<MainResponse> moviesSearch(@Query("query_term") String query_term);

    /**
     * @param id The ID of the movie
     * @return Returns the information about a specific movie
     */
    @GET("movie_details.json")
    Call<Movie> getMovieDetails(@Query("id") int id);


}
