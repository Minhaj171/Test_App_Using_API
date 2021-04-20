package com.example.testapp_usingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitClint retrofitClint = retrofit.create(RetrofitClint.class);

        Call<MainDataClass> call = retrofitClint.getData("C7P8uSigpJSjl4nXAnUjQU6Jx7keWqp2gkWWNAUrYrRz01t8WANhFD29GU7j");

        call.enqueue(new Callback<MainDataClass>() {
            @Override
            public void onResponse(Call<MainDataClass> call, Response<MainDataClass> response) {
                if (response.isSuccessful()){

                   List<ObjectData> list = response.body().getData();
                   for (ObjectData objectData : list){
                       Log.d("id", String.valueOf(objectData.getId()));
                       Log.d("name", String.valueOf(objectData.getName()));
                       Log.d("resource", String.valueOf(objectData.getResource()));
                       Log.d("updated_at", String.valueOf(objectData.getUpdated_at()));
                   }

                }else{
                    Log.d("response", "fail");
                }

            }

            @Override
            public void onFailure(Call<MainDataClass> call, Throwable t) {
                Log.d("response", "fail");
            }
        });
    }
}