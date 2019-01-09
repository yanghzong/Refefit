package com.example.refefit.utils;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Myinterface {
    //北京天气
    @GET("weather_mini")
    Observable<ResponseBody> getWeather(@Query("city") String city);
}
