package com.ewflorencio.testedois;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OneSetTimeReciver extends BroadcastReceiver {

    String TAG = OneSetTimeReciver.class.getName();


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e(TAG, "The BroadCast Receiver got Triggered");
        Toast.makeText(context, "A OneSetTimeReciver é chamada", Toast.LENGTH_LONG);

    }
}
