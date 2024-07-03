package com.example.movieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

//    ViewModel: Suitable for non-android-specific model
//    AndroidViewModel: used when viewModel class needs to access Android-specific components

    private MovieRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MovieRepository(application);
    }

//    Live Data
    public LiveData<List<Movie>> getAllMovies(){
        return repository.getMutableLiveData();
    }
}
