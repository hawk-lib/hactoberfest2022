package com.whawk.mark;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    //Preference Name
    private static final String shared_pref_name = "Mark_Preferences";
    //Preference keys
    private static final String name = "Name";
    private static final String password = "Password";
    private static final String pin = "Pin";
    private static final String email = "Email";
    private static final String uid = "Uid";
    //Instance
    private static SharedPrefManager mInstance;
    //Context
    private static Context mCtx;
    private  static SharedPreferences sharedPreferences;


    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void saveUser(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, user.getName());
        editor.putString(password, user.getPassword());
        editor.putString(pin, user.getPin());
        editor.putString(email, user.getEmail());
        editor.putString(uid, user.getUid());
        editor.apply();
    }

    public void deleteUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, "");
        editor.putString(password, "");
        editor.putString(pin, "");
        editor.putString(email, "");
        editor.putString(uid, "");
        editor.apply();
    }

    public boolean verifyPin(String match_pin){
        sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getString(pin, "").equals(match_pin);
    }
    public boolean verifyPassword(String match_password){
        sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getString(password, "").equals(match_password);
    }
    public String getName(){
        sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getString(name, "");
    }


    public String getUid() {
        sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getString(uid, "");
    }

    public void updateEmail(String _email) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(email, _email);
        editor.apply();
    }

    public void updatePassword(String _password) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(password, _password);
        editor.apply();
    }

    public void updatePin(String _pin) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(pin, _pin);
        editor.apply();
    }

    public String getEmail() {
        sharedPreferences = mCtx.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getString(email, "");
    }
}
