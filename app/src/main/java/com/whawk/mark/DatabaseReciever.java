package com.whawk.mark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class DatabaseReciever extends BroadcastReceiver {

    static String ACTION_DATABASE_CHANGED = "com.whawk.mark.DATABASE_CHANGED";
    @Override
    public void onReceive(Context context, Intent intent) {
        //getData(context);

    }
}
