package com.vic.base.network;

/**
 * Created by Administrator on 2016/6/9.
 */
public interface IHttpRequest {
    void requestString(String url);
    void requestJSON(String url);
    <T> T parse(T dataObject);

}
