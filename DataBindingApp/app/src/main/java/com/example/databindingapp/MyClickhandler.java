package com.example.databindingapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickhandler {

    Context context;

    public MyClickhandler(Context context) {
        this.context = context;
    }

    public void onButton1Clickd(View view){
        Toast.makeText(context, "First Button is Clicked", Toast.LENGTH_SHORT).show();
    }
}
