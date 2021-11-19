package com.example.a19113013_st088_pamuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MovieViewHolder>{

    private final Context mContext;
    private final List<Movie> dataList;

    public Adapter(Context mContext, List<Movie>dataList)
    {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.directory_movie,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        movieViewHolder.listtitle.setText(dataList.get(position).getTitle());
        movieViewHolder.listdesc.setText(dataList.get(position).getDescription());
        movieViewHolder.listrelease.setText(dataList.get(position).getRelease());

        Glide.with(mContext)
                .load("https://themoviedb.org/t/p/w500/"+dataList.get(position).getImage())
                .into(movieViewHolder.listimg);
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView listtitle;
        TextView listdesc;
        TextView listrelease;
        ImageView listimg;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            listtitle = (TextView) itemView.findViewById(R.id.list_title);
            listdesc = (TextView) itemView.findViewById(R.id.list_desc);
            listrelease = (TextView) itemView.findViewById(R.id.list_release);
            listimg = (ImageView) itemView.findViewById(R.id.list_img);

        }
    }
}
