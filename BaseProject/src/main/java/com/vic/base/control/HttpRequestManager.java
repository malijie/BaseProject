package com.vic.base.control;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vic.base.utils.Logger;
import com.vic.base.utils.Profile;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/9.
 */
public class HttpRequestManager {
    private static final Object sObject= new Object();
    private static HttpRequestManager sHttpRequestManager = null;
    private  RequestQueue queue = null;

    private HttpRequestManager(){
        queue = Volley.newRequestQueue(Profile.mContext);
    }

    public static HttpRequestManager getInstance(){
        if(sHttpRequestManager == null){
            synchronized (sObject){
                if(sHttpRequestManager == null){
                    sHttpRequestManager = new HttpRequestManager();
                }
            }
        }
        return sHttpRequestManager;
    }

    public void requestHttpForJSON(String url){
        Logger.d("MLJ","requestHttpForJSON");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        EventBus.getDefault().post(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.e("TAG", error.getMessage());
            }
        });
    }
}
