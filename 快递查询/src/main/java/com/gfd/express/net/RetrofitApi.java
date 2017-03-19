package com.gfd.express.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述：
 * 作者：郭富东
 * 创建日期： 2017/3/17 0017 下午 5:00
 * 更新日期：
 */
public class RetrofitApi {

    private static RetrofitApi instance = new RetrofitApi();
    private final RetrofitService retrofitService;

    private RetrofitApi(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.kuaidi100.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
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
