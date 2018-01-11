package com.example.ilijaangeleski.jam_justaddmusic.presenter;

import android.text.TextUtils;

import com.example.ilijaangeleski.jam_justaddmusic.callback.RepositoriesCallback;
import com.example.ilijaangeleski.jam_justaddmusic.manager.MainManager;
import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepo;
import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepositories;
import com.example.ilijaangeleski.jam_justaddmusic.view.MainView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */

public class MainPresenter {
    private MainManager mainManager;
    private WeakReference<MainView> mainViewWeakReference;
    private List<GitRepo> repositories = new ArrayList<>();
    private int page = 1;
    private String query;

    public MainPresenter(MainManager mainManager, WeakReference<MainView> view) {
        this.mainManager = mainManager;
        this.mainViewWeakReference = view;
    }

    public void fetchRepositories(String query) {
        if (!TextUtils.isEmpty(this.query) && !this.query.equals(query)) {
            page = 1;
            repositories.clear();
            MainView view = mainViewWeakReference.get();
            if (view != null) {
                view.resetScrollListener();
            }
        }
        this.query = query;
        mainManager.fetchRepositories(query, page, new RepositoriesCallback() {
            @Override
            public void onSuccess(GitRepositories response) {
                MainView view = mainViewWeakReference.get();
                if (view != null) {
                    if (response != null &&
                            response.getResults() != null &&
                            !response.getResults().isEmpty()
                    ) {
                        repositories.addAll(response.getResults());
                        view.updateView();
                        page++;
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                MainView view = mainViewWeakReference.get();
                if (view != null) {
                    view.showErrorGettingRepositories();
                }
            }
        });
    }

    public List<GitRepo> getRepositories() {
        return repositories;
    }
}
