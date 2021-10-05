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
        connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
         if (networkInfo != null && networkInfo.isConnected()) {
             
            if (isConnected()){
                return true;
            }else{
                return false;
            }
             
        } else {
            return false;
        }
    }
    
      private boolean isConnected() {
        try {
            HttpsURLConnection url_conn = (HttpsURLConnection) new URL("https://clients3.google.com/generate_204").openConnection();
            url_conn.setRequestProperty("User-Agent", "Android");
            url_conn.setRequestProperty("Connection", "close");
            url_conn.setConnectTimeout(1000);
            url_conn.connect();
            return url_conn.getResponseCode() == 204 && url_conn.getContentLength() == 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }
}
