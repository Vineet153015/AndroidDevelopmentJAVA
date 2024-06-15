package com.example.counterapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public void increaseCounter(View view){
        int currValue = count.getValue() != null ? count.getValue():0;

        count.setValue(currValue+1);
    }

    public LiveData<Integer> getCount() {
        return count;
    }
}
