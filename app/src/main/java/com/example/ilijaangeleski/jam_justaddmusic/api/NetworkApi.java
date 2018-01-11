package com.example.ilijaangeleski.jam_justaddmusic.api;

import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepositories;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */

public interface NetworkApi {
    String BASE_URL = "https://api.github.com/";

    @GET("search/repositories?q=tetris")
    Call<GitRepositories> fetchRepositories();
}
