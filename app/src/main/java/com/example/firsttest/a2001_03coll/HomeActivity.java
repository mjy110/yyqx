
package com.example.firsttest.a2001_03coll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        OkHttpClient okhttpclient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesIntesInterceptor()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpclient)
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getLoginInfo().enqueue(new Callback<DataInfoBean>() {
            @Override
            public void onResponse(Call<DataInfoBean> call, retrofit2.Response<DataInfoBean> response) {
                if(response.body().getErrorCode()==0){
                    Log.i("tag","获取文章列表成功");
                    for(int i=0;i<response.body().getData().getDatas().size();i++){
                        Log.i("tag","收藏的标题名为："+response.body().getData().getDatas().get(i).getTitle());
                    }
                }else{
                    Log.i("tag","获取文章失败"+response.body().getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<DataInfoBean> call, Throwable t) {

            }
        });
    }
    //从sharedpreference中读取cookie并添加到头部
    public class AddCookiesIntesInterceptor implements Interceptor {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
   //         HashSet<String> perferences = (HashSet<String>) App.getSp().getStringSet("cookie", null);
            SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
            String perferences = test.getString("cookie", null);
            if (perferences != null) {
                    builder.addHeader("Cookie", perferences);
            }
            return chain.proceed(builder.build());
        }
    }
}
