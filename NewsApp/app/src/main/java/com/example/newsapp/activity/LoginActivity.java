package com.example.newsapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.activity.admin.AdminActivity;
import com.example.newsapp.pojo.LoginResult;
import com.example.newsapp.util.RequestDialog;
import com.example.newsapp.util.Token_session;
import com.example.newsapp.util.doUrl;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText accnum;
    private EditText password;
    private Button login;
    private Button sign;
    private RequestDialog requestDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        requestDialog=new RequestDialog(LoginActivity.this);
        accnum=findViewById(R.id.accnum);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(accnum.getText())){
                    Toast.makeText(LoginActivity.this, "帐号不能为空!", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password.getText())){
                    Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                }else{
                    if(accnum.getText().toString().equals("superadmin")&&password.getText().toString().equals("666")){
                        startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                        finish();
                    }else{
                        get_result(accnum.getText().toString(),password.getText().toString());

                    }
                }
            }
        });
        sign=findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }

    private Handler handler=new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==200){
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            }else if(msg.what==301){
                Toast.makeText(LoginActivity.this, "帐号不存在！", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==302){
                Toast.makeText(LoginActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==303){
                Toast.makeText(LoginActivity.this, "帐号已被注册！", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private void get_result(String usercode,String userpassword){
        requestDialog.show();
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("usercode", usercode)
                .add("password",userpassword)
                .build();
        final Request request=new Request.Builder()
                .url(doUrl.dolgin)
                .post(formBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(Log.getStackTraceString(e));
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                requestDialog.dismiss();
                String json= response.body().string();
                Message message = new Message();
                try {
                    JSONObject jsonObject=new JSONObject(json);
                    if(jsonObject.getInt("code")==200){
                        Gson gson=new Gson();
                        LoginResult loginResult = gson.fromJson(json,LoginResult.class);
                        Token_session.cacheToken(getApplicationContext(),loginResult.getMsg());
                        message.what=200;
                    }else if(jsonObject.getInt("code")==301){
                        message.what=301;
                    }else if(jsonObject.getInt("code")==302){
                        message.what=302;
                    }
                    else if(jsonObject.getInt("code")==303){
                        message.what=303;
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}