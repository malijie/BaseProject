package com.vic.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;


/**
 * Created by malijie on 2016/6/9
 */
public class Utils {
    /**
     * TODO 判断网络状态是否可用
     *
     * @return true: 网络可用 ; false: 网络不可用
     */
    public static boolean hasInternet() {
        ConnectivityManager m = (ConnectivityManager) Profile.mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (m == null) {
            return false;
        } else {
            NetworkInfo[] info = m.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Logger.d("NetWorkState", "Availabel");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @return 是否是wifi网络
     */
    public static boolean isWifi() {
        ConnectivityManager m = (ConnectivityManager) Profile.mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if(m != null){
            NetworkInfo n = m.getActiveNetworkInfo();
            if (n != null && n.getType() == ConnectivityManager.TYPE_WIFI)
                return true;
        }
        return false;
    }

    /**
     * @return 网络类型
     */
    public static int getNetworkType() {
        ConnectivityManager m = (ConnectivityManager) Profile.mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = m.getActiveNetworkInfo();
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                return NetworkType.WIFI;
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                        return NetworkType.LxRTT;
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                        return NetworkType.CDMA;
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                        return NetworkType.EDGE;
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                        return NetworkType.EHRPD;
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        return NetworkType.EVDO_0;
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        return NetworkType.EVDO_A;
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        return NetworkType.EVDO_B;
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                        return NetworkType.GPRS;
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                        return NetworkType.HSDPA;
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                        return NetworkType.HSPA;
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        return NetworkType.HSPAPlus;
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                        return NetworkType.HSUPA;
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        return NetworkType.IDEN;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return NetworkType.LTE;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                        return NetworkType.UMTS;
                }
            }
        }
        return NetworkType.UNKNOWN;
    }

    /** Returns 是否有SD卡 */
    public static boolean hasSDCard() {
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState()))
            return true;
        return false;
    }

}
