package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


//    THIS METHOD WIL WORK ONLY WITH THE DEVICE THAT TARGET APP LOWER THAN 26 like we did in AndroidManifest.xml file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for devices with above 26 API

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        AirplaneModeReceiver br = new AirplaneModeReceiver();
        registerReceiver(br,intentFilter);
    }
}