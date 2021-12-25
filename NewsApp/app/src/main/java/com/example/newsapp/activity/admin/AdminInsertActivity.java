package com.example.newsapp.activity.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.pojo.NewsDict;
import com.example.newsapp.pojo.PicSrcResult;
import com.example.newsapp.util.Token_session;
import com.example.newsapp.util.doUrl;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
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

public class AdminInsertActivity extends AppCompatActivity {

    private EditText title;
    private EditText text;
    private ImageView pic1;
    private String mSelectPath1;
    private ImageView pic2;
    private String mSelectPath2;
    private ImageView pic3;
    private String mSelectPath3;
    private Button submit;
    private EditText publisher;
    private String [] picurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);
        init();
    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==1){
                pic1.setImageBitmap(BitmapFactory.decodeFile(mSelectPath1));
                return true;
            }else if(msg.what==2){
                pic2.setImageBitmap(BitmapFactory.decodeFile(mSelectPath2));
                return true;
            }else if(msg.what==3){
                pic3.setImageBitmap(BitmapFactory.decodeFile(mSelectPath3));
                return true;
            }else if(msg.what==200){
                Toast.makeText(AdminInsertActivity.this, "增加成功！", Toast.LENGTH_SHORT).show();
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
                String newsjson = gson.toJson(new NewsDict(null,title.getText().toString(),text.getText().toString()
                        ,publisher.getText().toString(),urls), NewsDict.class);
                insert_news(newsjson);
            }
            return false;
        }
    });
    private void init(){
        title=findViewById(R.id.title);
        text=findViewById(R.id.text);
        pic1=findViewById(R.id.pic1);
        pic2=findViewById(R.id.pic2);
        pic3=findViewById(R.id.pic3);
        publisher=findViewById(R.id.publisher);
        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminInsertActivity.this, MultiImageSelectorActivity.class);
                // 是否显示调用相机拍照
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA,true);
                // 设置模式（单选 MODE_SINGLE /多选MODE_MULTI)
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE,MultiImageSelectorActivity.MODE_SINGLE);
                startActivityForResult(intent,1);
            }
        });
        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminInsertActivity.this, MultiImageSelectorActivity.class);
                // 是否显示调用相机拍照
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA,true);
                // 设置模式（单选 MODE_SINGLE /多选MODE_MULTI)
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE,MultiImageSelectorActivity.MODE_SINGLE);
                startActivityForResult(intent,2);
            }
        });
        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminInsertActivity.this, MultiImageSelectorActivity.class);
                // 是否显示调用相机拍照
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA,true);
                // 设置模式（单选 MODE_SINGLE /多选MODE_MULTI)
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE,MultiImageSelectorActivity.MODE_SINGLE);
                startActivityForResult(intent,3);
            }
        });
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload_mutifiles();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Message message = new Message();
        if(resultCode==RESULT_OK&&requestCode==1&&data!=null){
            mSelectPath1 = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
            message.what=1;
        }else if(resultCode==RESULT_OK&&requestCode==2&&data!=null){
            mSelectPath2 = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
            message.what=2;
        }else if(resultCode==RESULT_OK&&requestCode==3&&data!=null){
            mSelectPath3 = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
            message.what=3;
        }handler.sendMessage(message);
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
                .addFormDataPart("token_session", Token_session.getSuperToken()            )
                .addFormDataPart("picFiles","pic1",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath1)))
                .addFormDataPart("picFiles","pic2",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath2)))
                .addFormDataPart("picFiles","pic3",RequestBody.create(MediaType.parse("application/octet-stream"),new File(mSelectPath3)))
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
    private void insert_news(String NewsDiceJson){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()

                .add("token_session", Token_session.getSuperToken())
                .add("NewsDiceJson", NewsDiceJson)
                .build();
        Request request=new Request.Builder()
                .url(doUrl.doinsertnews)
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
}