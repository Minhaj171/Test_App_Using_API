package com.example.testapp_usingapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClint {
    @GET("continents")
    Call<MainDataClass> getData(@Query("api_token") String token);
}
