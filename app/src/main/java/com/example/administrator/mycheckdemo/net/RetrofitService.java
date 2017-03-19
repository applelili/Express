package com.example.administrator.mycheckdemo.net;



import com.example.administrator.mycheckdemo.entity.Model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 类描述：
 * 作者：郭富东
 * 创建日期： 2017/3/17 0017 下午 5:03
 * 更新日期：
 */
//具体访问网络的api
public interface RetrofitService{

    @GET("query")
    Call<Model> getExpressInfo(@QueryMap Map<String, String> params);
}
