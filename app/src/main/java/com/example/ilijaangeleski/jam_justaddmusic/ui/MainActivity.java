package com.example.ilijaangeleski.jam_justaddmusic.ui;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilijaangeleski.jam_justaddmusic.MyApp;
import com.example.ilijaangeleski.jam_justaddmusic.R;
import com.example.ilijaangeleski.jam_justaddmusic.adapter.EndlessRecyclerViewScrollListener;
import com.example.ilijaangeleski.jam_justaddmusic.adapter.RepositoriesRecyclerViewAdapter;
import com.example.ilijaangeleski.jam_justaddmusic.di.components.DaggerMainActivityComponent;
import com.example.ilijaangeleski.jam_justaddmusic.di.modules.MainActivityModule;
import com.example.ilijaangeleski.jam_justaddmusic.presenter.MainPresenter;
import com.example.ilijaangeleski.jam_justaddmusic.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.searchRepo)
    EditText searchRepo;

    @Inject
    MainPresenter presenter;

    private RepositoriesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createDependencies();
        initView();
        initListeners();
        presenter.fetchRepositories(searchRepo.getText().toString());
    }

    private void createDependencies() {
        DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new MainActivityModule(this))
                .baseComponent(MyApp.getMyApp().getBaseComponent())
                .build()
                .inject(this);
    }

    private void initView() {
        adapter = new RepositoriesRecyclerViewAdapter(
                presenter.getRepositories(),
                R.layout.item_repository
        );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.fetchRepositories(searchRepo.getText().toString());
            }
        });
    }

    private void initListeners() {
        searchRepo.addTextChangedListener(new TextWatcher() {
            CountDownTimer timer = null;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (timer != null) {
                    timer.cancel();
                }
                timer = new CountDownTimer(500, 250) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        presenter.fetchRepositories(searchRepo.getText().toString());
                    }
                }.start();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void updateView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorGettingRepositories() {
        Toast.makeText(this, R.string.error_getting_repositories, Toast.LENGTH_LONG).show();
    }
}
