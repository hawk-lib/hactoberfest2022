package com.whawk.mark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import static com.whawk.mark.HomeActivity.onlineStatus;

public class InternetConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


        onlineStatus(InternetConectivity.getInstance(context).checkInternetConnection());

    }
}
