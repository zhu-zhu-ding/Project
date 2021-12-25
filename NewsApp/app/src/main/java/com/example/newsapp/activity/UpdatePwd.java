package com.example.newsapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.newsapp.pojo.LoginResult;
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

public class UpdatePwd extends AppCompatActivity {

    private EditText pwd1;
    private EditText pwd2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        init();
    }
    private void init(){
        pwd1=findViewById(R.id.pwd1);
        pwd2=findViewById(R.id.pwd2);
        button=findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(pwd1.getText())||TextUtils.isEmpty(pwd2.getText())){
                    Toast.makeText(UpdatePwd.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                }else if(!pwd1.getText().toString().equals(pwd2.getText().toString())){
                    Toast.makeText(UpdatePwd.this, "密码不一致！", Toast.LENGTH_SHORT).show();
                }else{
                    doUpdate(pwd1.getText().toString());
                }
            }
        });
    }
    private Handler handler=new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==200){
                Toast.makeText(UpdatePwd.this, "修改成功！", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
            else{
                Toast.makeText(UpdatePwd.this, "修改失败！", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private void doUpdate(String userpwd){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("token_session", Token_session.getCachedToken(UpdatePwd.this))
                .add("userpwd",userpwd)
                .build();
        final Request request=new Request.Builder()
                .url(doUrl.updatepwd)
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
                String json= response.body().string();
                Message message = new Message();
                try {
                    JSONObject jsonObject=new JSONObject(json);
                    if(jsonObject.getInt("code")==200){
                        message.what=200;
                    }
                    else{
                        message.what=0;
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}