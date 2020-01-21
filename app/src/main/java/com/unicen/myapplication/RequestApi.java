package com.unicen.myapplication;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

public interface RequestApi {
    @GET("todos/1")
    Observable<ResponseBody> makeQuery();
}
