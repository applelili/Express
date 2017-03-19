package com.example.administrator.mycheckdemo.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/18.
 */
//创建实例
public class RetrofitApi {
    private static RetrofitApi instance=new RetrofitApi();
    private final RetrofitService retrofitService;

    private RetrofitApi(){
        OkHttpClient okHttpClient=new OkHttpClient();
        //自动转换器
      Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("http://www.kuaidi100.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())//自动转换器
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }
    public static RetrofitApi getInstance(){
        return instance;
    }
    public RetrofitService getRetrofitService(){
        return retrofitService;
    }
}
