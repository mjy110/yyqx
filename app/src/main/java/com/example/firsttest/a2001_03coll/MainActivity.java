package com.example.firsttest.a2001_03coll;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText admin;
    private EditText passWord;
    private HashSet<String> cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        admin = (EditText) findViewById(R.id.admin);
        admin.setOnClickListener(this);
        passWord = (EditText) findViewById(R.id.passWord);
        passWord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                initRetrofit();
                break;
        }
    }
    private void initRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("tag", "拦截器接收的数据" + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
       .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new ReceivedCookiesInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Map<String,Object> param=new HashMap<>();
        param.put("username","098098");
        param.put("password","111111");
        apiService.getDataInfo(param).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, retrofit2.Response<LoginBean> response) {
                     Log.e("tag==",response.toString());
                     Headers headers = response.headers();
                     List<String> values = headers.values("Set-Cookie");
                     Log.e("tag==",values.toString());
                     String str = values.get(0);
                     int i = str.indexOf(";");
                     String substring = str.substring(0, i);
                     SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
                     SharedPreferences.Editor edit = test.edit();
                     edit.putString("cookie", substring);
                     edit.commit();
                     Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                     startActivity(intent);
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.e("tagee","登录失败");
            }
        });
    }
//通过SharePreference将Cookie信息保存在本地
    public class ReceivedCookiesInterceptor implements Interceptor {
        public Response intercept(Chain chain) throws IOException {

           RequestBody requestBody = new FormBody.Builder()
                    .build();

            Request device = chain.request().newBuilder()
                    .post(requestBody).build();

            Response response = chain.proceed(chain.request());
            Headers headers = response.headers();
            List<String> values = headers.values("Set-Cookie");
            String str = values.get(0);
            int i = str.indexOf(";");
            String substring = str.substring(0, i);
            Log.e("tag", "interceptor自定义：" + substring);
            //拦截的cookie保存在orginalResponse中
           /* Response orginalResponse = chain.proceed(chain.request());
            if(!orginalResponse.headers("Set-Cookie").isEmpty()) {
                cookies = new HashSet<>();
                for (String header : orginalResponse.headers(("Set-Cookie"))) {
                    Log.e("tag", "拦截的cookie是" + header);
                    cookies.add(header);
                }
            }*/
                //保存的sharepreference文件名为cookieData
                // App.getSp().edit().putStringSet("cookie",cookies).commit();
               /* SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
                SharedPreferences.Editor edit = test.edit();
                edit.putString("cookie", cookies);
                edit.commit();*/
           // Log.i("TAG",orginalResponse.headers("Set-Cookie").toString());
            return response;
        }
    }
}
