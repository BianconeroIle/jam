package com.example.ilijaangeleski.jam_justaddmusic.manager;

import com.example.ilijaangeleski.jam_justaddmusic.api.NetworkApi;
import com.example.ilijaangeleski.jam_justaddmusic.callback.RepositoriesCallback;
import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepositories;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */

public class MainManager {
    private NetworkApi networkApi;

    public MainManager(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public void fetchRepositories(String query,final RepositoriesCallback callback){
        networkApi.fetchRepositories(query).enqueue(new Callback<GitRepositories>() {
            @Override
            public void onResponse(Call<GitRepositories> call, Response<GitRepositories> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GitRepositories> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
