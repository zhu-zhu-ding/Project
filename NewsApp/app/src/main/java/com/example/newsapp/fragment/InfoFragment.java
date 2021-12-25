package com.example.newsapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.activity.LoginActivity;
import com.example.newsapp.activity.MainActivity;
import com.example.newsapp.activity.SignActivity;
import com.example.newsapp.activity.UpdatePwd;
import com.example.newsapp.activity.UpdateUsername;
import com.example.newsapp.pojo.InfoResult;
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

public class InfoFragment extends Fragment {


    private View root;
    private Button exit;
    private Button updatepwd;
    private Button updatename;
    private TextView user_name;
    private TextView user_code;
    private InfoResult infoResult;

    @Override
    public void onResume() {
        super.onResume();
        get_userInfo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(root==null){
            root=inflater.inflate(R.layout.fragment_info, container, false);
        }
        init();
        return root;
    }
    private void init(){
        exit=root.findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_exit();
            }
        });
        updatepwd=root.findViewById(R.id.updatepwd);
        updatepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), UpdatePwd.class));
            }
        });
        updatename=root.findViewById(R.id.updatename);
        updatename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), UpdateUsername.class));
            }
        });
        user_name=root.findViewById(R.id.user_name);
        user_code=root.findViewById(R.id.user_code);
    }
    private Handler handler=new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==200){
                user_name.setText("昵称："+infoResult.getNewsUser().getUserName());
                user_code.setText("帐号："+infoResult.getNewsUser().getUserCode());
                return true;
            }
            else if(msg.what==201) {
                Token_session.clearToken(getContext());
                Intent intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }else if(msg.what==0){
                Toast.makeText(getContext(), "获取信息失败！", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==1){
                Toast.makeText(getContext(), "退出登录失败！", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private void get_userInfo(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("token_session", Token_session.getCachedToken(getContext()))
                .build();
        Request request=new Request.Builder()
                .url(doUrl.dogetInfo)
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
                        Gson gson=new Gson();
                        infoResult = gson.fromJson(json,InfoResult.class);
                        message.what=200;
                    }else{
                        message.what=0;
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void do_exit(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("token_session", Token_session.getCachedToken(getContext()))
                .build();
        Request request=new Request.Builder()
                .url(doUrl.doexit)
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
                        message.what=201;
                    }else{
                        message.what=1;
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}