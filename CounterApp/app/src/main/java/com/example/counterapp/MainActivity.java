package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.View;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        mainBinding.setMyvariable(viewModel);


        viewModel.getCount().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer count) {
                        mainBinding.answer.setText(""+count);
                    }
                }
        );

    }
}