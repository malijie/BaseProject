package com.vic.base.network;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vic.base.utils.Logger;
import com.vic.base.utils.Profile;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/**
 * Created by malijie on 2016/6/9.
 */
public class HttpGetRequest implements IHttpRequest{
    private static final Object sObject= new Object();
    private static HttpGetRequest sHttpGetRequest = null;
    private RequestQueue queue = null;

    private HttpGetRequest(){
        queue = Volley.newRequestQueue(Profile.mContext);
    }

    public static void getInstance(){
        if(sHttpGetRequest == null){
            synchronized (sObject){
                if(sHttpGetRequest == null){
                    sHttpGetRequest = new HttpGetRequest();
                }
            }
        }
    }

    @Override
    public void requestString(String url) {
    }

    @Override
    public void requestJSON(String url) {
        JsonObjectRequest jsonObjectRequest;
        jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Logger.d("TAG", response.toString());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.e("TAG", error.getMessage());
            }
        });
    }

    @Override
    public <T> T parse(T dataObject) {
        return null;
    }

}
