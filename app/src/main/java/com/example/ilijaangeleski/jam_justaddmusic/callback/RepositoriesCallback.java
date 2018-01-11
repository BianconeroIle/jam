package com.example.ilijaangeleski.jam_justaddmusic.callback;

import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepositories;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */

public interface RepositoriesCallback {
    void onSuccess(GitRepositories response);

    void onFailure(Throwable t);

}
