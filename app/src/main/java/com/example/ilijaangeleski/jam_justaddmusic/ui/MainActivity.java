package com.example.ilijaangeleski.jam_justaddmusic.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.ilijaangeleski.jam_justaddmusic.R;
import com.example.ilijaangeleski.jam_justaddmusic.adapter.RepositoriesRecyclerViewAdapter;
import com.example.ilijaangeleski.jam_justaddmusic.presenter.MainPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.searchRepo)
    EditText searchRepo;

    MainPresenter presenter;

    private RepositoriesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        presenter.fetchRepositories();
    }

    private void initView(){
        adapter = new RepositoriesRecyclerViewAdapter(
                presenter.getRepositories(),
                R.layout.item_repository
        );
        recyclerView.setAdapter(adapter);
    }
}
