package com.example.admin.broadcastrecieverproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.security.Permission;

public class SystemBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction())
        {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d("SYS_TAG", "Airplane mode changed");
                Toast.makeText(context, "airplane mode changed", Toast.LENGTH_SHORT);
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Log.d("SYS_TAG", "Power connected");
                Toast.makeText(context, "power changed", Toast.LENGTH_SHORT);
                break;
            case Intent.ACTION_SCREEN_ON:
                Log.d("SYS_TAG", "Screen on");
                Toast.makeText(context, "screen on", Toast.LENGTH_SHORT);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Log.d("SYS_TAG", "Power disconnected");
                Toast.makeText(context, "power disconnected", Toast.LENGTH_SHORT);
                break;
            case Intent.ACTION_SCREEN_OFF:
                Log.d("SYS_TAG", "Screen off");
                Toast.makeText(context, "screen off", Toast.LENGTH_SHORT);
                break;
        }
    }
}
