package com.whawk.mark;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetConectivity {

    private Context context;
    private static InternetConectivity mInstance;

    public InternetConectivity(Context context) {
        this.context = context;
    }

    public static synchronized InternetConectivity getInstance(Context context) {
        if (mInstance == null){
            mInstance = new InternetConectivity(context);
        }
        return mInstance;
    }

    public boolean checkInternetConnection() {
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }
}
