package com.example.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.databinding.MovieListItemBinding;
import com.example.movieapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding binding = DataBindingUtil.
                inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.movie_list_item,
                        parent,
                        false
                );
        return new MovieViewHolder(binding);
    }


//    this method is called when the data is to be displayed
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);

    }


//    this is called to get the number of items
    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class MovieViewHolder extends  RecyclerView.ViewHolder{
    private MovieListItemBinding movieListItemBinding;

        public MovieViewHolder( MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }
}
