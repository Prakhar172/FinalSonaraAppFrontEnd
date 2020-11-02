package com.example.sonaraapp.commonclasses;


import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


import static android.content.Context.MODE_PRIVATE;

public class SharedData {
    private Context mctx;
    final String SHARED_PREF_NAME = "mysharedpref";
    final String KEY_MOBILE = "mobile";
    final String KEY_ID = "id";
    final String KEY_NAME = "name";
    public SharedData(Context mctx){
        this.mctx = mctx;
    }


    public boolean SaveSharedPrefernce(String mobile,String id,String name){
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_MOBILE, mobile); // keyname =2
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_ID,id);
        editor.apply();
        return true;
    }
    public boolean GetSharedPrefernce(){
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String mobile = sp.getString(KEY_MOBILE, null);
        if (mobile != null) {
            return true;
        }
        else{
            return false;
        }
    }

    public String GetName(){
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME,null);
        return name;
    }
    public String GetMobile(){
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String mobile = sp.getString(KEY_MOBILE,null);
        return mobile;
    }
    public String GetId(){
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String id = sp.getString(KEY_ID,null);
        return id;
    }

    public boolean clearSharedPreferences() {
        SharedPreferences sp = mctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String mobile = sp.getString(KEY_MOBILE, null);
        String id = sp.getString(KEY_ID,null);
        String name = sp.getString(KEY_NAME,null);
        editor.remove(mobile);
        editor.remove(id);
        editor.commit();
        editor.clear();
        editor.commit();
        return true;

    }
}