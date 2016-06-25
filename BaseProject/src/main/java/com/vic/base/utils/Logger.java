package com.vic.base.utils;

import android.util.Log;

import com.vic.base.BuildConfig;

/**
 * Created by malijie on 2016/6/9.
 */
public class Logger {
    private static boolean sIsOpen = false;
    public static void setLogSwitch(boolean isOpen){
        sIsOpen = isOpen;
    }

    public static void v(String tag,String msg){
        if(sIsOpen){
            Log.v(tag,msg);
        }
    }

    public static void e(String tag,String msg){
        if(sIsOpen){
            Log.e(tag,msg);
        }
    }

    public static void i(String tag,String msg){
        if(sIsOpen){
            Log.i(tag,msg);
        }
    }

    public static void w(String tag,String msg){
        if(sIsOpen){
            Log.w(tag,msg);
        }
    }

    public static void d(String tag,String msg){
        if(sIsOpen){
            Log.d(tag,msg);
        }
    }
}
