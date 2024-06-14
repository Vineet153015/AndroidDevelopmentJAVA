package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        THIS METHOD IS CALLED WHEN THE BROADCAST RECEIVER RECEIVES THE BROADCAST

        if(intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state",false);
            String msg = isAirplaneModeOn ? "Airplane Mode is ON" : "Airplane Mode if OFF";
            Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
        }
    }
}
