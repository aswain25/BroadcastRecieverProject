package com.example.recieverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReciever myBrodcastReciever;
    public static TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //myBrodcastReciever = new MyBroadcastReciever();
        //IntentFilter intentFilter = new IntentFilter();
        //intentFilter.addAction("myAction");
        //registerReceiver(myBrodcastReciever, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(myBrodcastReciever);
    }

}
