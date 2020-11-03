package com.example.firsttest.a2001_03coll;

import android.app.Application;
import android.content.SharedPreferences;

/*
修改       确认修改
*/public class App extends Application {
    public static SharedPreferences sp;
    public void onCreate() {

        super.onCreate();
        sp=getSharedPreferences("config",MODE_PRIVATE);
    }
    public static SharedPreferences getSp(){
        return sp;
    }
}
