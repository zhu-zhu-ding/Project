package com.example.newsapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.adpter.PicAdapter;
import com.example.newsapp.pojo.CommentItem;
import com.example.newsapp.pojo.NewsComment;
import com.example.newsapp.pojo.NewsItem;
import com.example.newsapp.pojo.PicSrcResult;
import com.example.newsapp.util.RequestDialog;
import com.example.newsapp.util.Token_session;
import com.example.newsapp.util.doUrl;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommentActivity extends AppCompatActivity {

    private Button cancel;
    private Button submit;
    private Button openalbum;
    private EditText text;
    private RecyclerView recyclerView;
    private String [] picurl;
    private ArrayList<String> mSelectPath;
    private RequestDialog requestDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        init();
    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==1){
                LinearLayoutManager layoutManager = new LinearLayoutManager(CommentActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                PicAdapter picAdapter = new PicAdapter(mSelectPath,CommentActivity.this);
                recyclerView.setAdapter(picAdapter);
                return true;
            }else if(msg.what==200){
                requestDialog.dismiss();
                Toast.makeText(CommentActivity.this, "发表成功！", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if(msg.what==201){
                Gson gson = new Gson();
                String urls="";
                for(int i=0;i<picurl.length;i++){
                    if(i==picurl.length-1){
                        urls+=picurl[i];
                    }else{
                        urls+=picurl[i]+",";
                    }
                }
                String commentJson = gson.toJson(new NewsComment(null,text.getText().toString(),urls,
                        Token_session.getCachedToken(CommentActivity.this)),NewsComment.class);
                upload_comments(commentJson);
            }
            return false;
        }
    });
    private void init(){
        requestDialog=new RequestDialog(CommentActivity.this);
        cancel=findViewById(R.id.cancel);
        submit=findViewById(R.id.submit);
        openalbum=findViewById(R.id.open_album);
        text=findViewById(R.id.text);
        recyclerView=findViewById(R.id.recycleview);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestDialog.show();
                if(mSelectPath.size()>0){
                    upload_mutifiles();
                }else {
                    Gson gson = new Gson();
                    String commentJson = gson.toJson(new NewsComment(null,text.getText().toString(),null,
                            Token_session.getCachedToken(CommentActivity.this)),NewsComment.class);
                    upload_comments(commentJson);
                }
            }
        });
        openalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CommentActivity.this, MultiImageSelectorActivity.class);
                // 是否显示调用相机拍照
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA,true);
                // 设置模式（单选 MODE_SINGLE /多选MODE_MULTI)
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE,MultiImageSelectorActivity.MODE_MULTI);
                startActivityForResult(intent,3);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==3&&data!=null){
            mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);
        }
    }
    private void upload_comments(String commentJson){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("token_session", Token_session.getCachedToken(CommentActivity.this))
                .add("commentJson", commentJson)
                .build();
        Request request=new Request.Builder()
                .url(doUrl.upLoadComment)
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
                    System.out.println(json);
                    JSONObject jsonObject=new JSONObject(json);
                    if(jsonObject.getInt("code")==200){
                        message.what=200;
                    }else if(jsonObject.getInt("code")==0){
                        message.what=0;
                    }
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void upload_mutifiles(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("token_session", Token_session.getCachedToken(CommentActivity.this))
                .addFormDataPart("picFiles","pic1",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath.get(0))))
                .addFormDataPart("picFiles","pic2",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath.get(1))))
                .addFormDataPart("picFiles","pic3",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath.get(2))))
//                .addFormDataPart("picFiles","pic4",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath.get(3))))
                .build();
        Request request=new Request.Builder()
                .url(doUrl.uploadMultipleFile)
                .post(requestBody)
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
                    System.out.println(jsonObject);
                    if(jsonObject.getInt("code")==200){
                        message.what=201;
                        Gson gson = new Gson();
                        PicSrcResult picSrcResult=gson.fromJson(json,PicSrcResult.class);
                        picurl=picSrcResult.getPicurl();
                    }else if(jsonObject.getInt("code")==0){
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