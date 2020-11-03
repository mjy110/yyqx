package com.example.firsttest.a2001_03coll;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/*
修改       确认修改
*/public interface ApiService {
    public static final String BASE_URL="https://www.wanandroid.com/";
    @POST("use/login")
    @FormUrlEncoded


    Call<LoginBean> getDataInfo(@FieldMap Map<String,Object> map);
    @GET("lg/collect/list/0/json")
    Call<DataInfoBean> getLoginInfo();
}
