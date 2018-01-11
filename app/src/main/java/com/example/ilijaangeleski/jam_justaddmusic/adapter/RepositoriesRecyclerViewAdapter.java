package com.example.ilijaangeleski.jam_justaddmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilijaangeleski.jam_justaddmusic.R;
import com.example.ilijaangeleski.jam_justaddmusic.model.GitRepo;
import com.example.ilijaangeleski.jam_justaddmusic.util.CircleTransform;
import com.squareup.picasso.Picasso;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 1/11/2018.
 */

public class RepositoriesRecyclerViewAdapter extends RecyclerView.Adapter<RepositoriesRecyclerViewAdapter.MyViewHolder> {
    private List<GitRepo> repos;
    private int layoutResourceId;

    public RepositoriesRecyclerViewAdapter(List<GitRepo> repos, int layoutResourceId) {
        this.repos = repos;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public RepositoriesRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RepositoriesRecyclerViewAdapter.MyViewHolder holder, int position) {
        final GitRepo current = repos.get(position);
        holder.repositoryName.setText(current.getName());
        holder.loginName.setText(current.getOwner().getLogin());
        holder.sizeOfRepositories.setText(current.getSize());
        Picasso.with(holder.avatar.getContext()).load(current.getOwner().getAvatarUrl())
                .transform(new CircleTransform()).placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round)
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.repositoryName)
        TextView repositoryName;
        @BindView(R.id.loginName)
        TextView loginName;
        @BindView(R.id.sizeOfRepositories)
        TextView sizeOfRepositories;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
