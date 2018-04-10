package com.example.admin.broadcastrecieverproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnBroadcast;
    int current = 0;
    ResultReceiver receiver = new MyResultsReciever();
    LocalBroadcastReceiver localReceiver = new LocalBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBroadcast = findViewById(R.id.btnBroadcast);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(localReceiver,
                new IntentFilter("localAction"));

    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
    }

    public void btn_Clicked(View view)
    {
        Intent intent = new Intent("localAction");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }

    public void increment_Clicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.putExtra("data", current);
        intent.putExtra("reciever", receiver);
        startService(intent);
    }

    public class MyResultsReciever extends ResultReceiver
    {
        public MyResultsReciever() {
            super(new Handler());
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            current = resultData.getInt("result");
            btnBroadcast.setText("Send: " + current);
        }
    }
    public class LocalBroadcastReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Intent intent2 = new Intent();
            intent2.setAction("myAction");
            intent2.putExtra("msg", btnBroadcast.getText().toString());
            //sendBroadcast(intent2/*, Manifest.permission.myPermission*/);
            sendOrderedBroadcast(intent2, null, null, null, Activity.RESULT_OK, null, null);
            Log.d("BROAD_TAG", "Broadcasted");
        }
    }

}
