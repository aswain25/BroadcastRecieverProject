package com.example.recieverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReciever extends BroadcastReceiver
{
    public MyBroadcastReciever(){}

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("BROAD_TAG", "Recieved Broadcast");
        MainActivity.tvMain.setText(intent.getStringExtra("msg"));
    }
}