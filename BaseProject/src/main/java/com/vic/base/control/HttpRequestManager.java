package com.vic.base.control;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vic.base.utils.Logger;
import com.vic.base.utils.Profile;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/9.
 */
public class HttpRequestManager {
    private static final Object sObject= new Object();
    private static HttpRequestManager sHttpRequstManager = null;
    private  RequestQueue queue = null;

    private HttpRequestManager(){
        queue = Volley.newRequestQueue(Profile.mContext);
    }

    public static void getInstance(){
        if(sHttpRequstManager == null){
            synchronized (sObject){
                if(sHttpRequstManager == null){
                    sHttpRequstManager = new HttpRequestManager();
                }
            }
        }
    }

//    public void requestHttpForJSON(String url){
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(("http://m.weather.com.cn/data/101010100.html", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Logger.d("TAG", response.toString());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Logger.e("TAG", error.getMessage());
//            }
//        });
//    }
}
