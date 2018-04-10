package com.example.admin.broadcastrecieverproject;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService
{
    public MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResultReceiver resultReceiver = intent.getParcelableExtra("reciever");
        Bundle bundle = new Bundle();
        bundle.putInt("result", intent.getIntExtra("data", -1) + 1);
        resultReceiver.send(0, bundle);

        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
