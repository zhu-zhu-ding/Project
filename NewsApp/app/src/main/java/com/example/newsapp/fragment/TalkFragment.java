package com.example.newsapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.activity.CommentActivity;
import com.example.newsapp.activity.NewItemActivity;
import com.example.newsapp.adpter.CommentAdapter;
import com.example.newsapp.adpter.MainItemsAdpater;
import com.example.newsapp.pojo.CommentItem;
import com.example.newsapp.pojo.NewsItem;
import com.example.newsapp.util.Token_session;
import com.example.newsapp.util.doUrl;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TalkFragment extends Fragment {
    private View root;
    private RecyclerView commentList;
    private SwipeRefreshLayout swipeLayout;
    private EditText find;
    private List<CommentItem.MsgBean> list;
    private Button publish;
    private CommentAdapter adpater;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(root==null){
            root=inflater.inflate(R.layout.fragment_talk, container, false);
        }
        init();
        return root;
    }
    private Handler handler=new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==200){
//                adpater.notifyDataSetChanged();
//                System.out.println(list.size());
                System.out.println("666");
                adpater=new CommentAdapter(list,getContext());
                commentList.setAdapter(adpater);
                return true;
            }else if(msg.what==301){
                Toast.makeText(getContext(), "帐号不存在！", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private void init(){
        list=new ArrayList<>();
        commentList=root.findViewById(R.id.news_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(commentList);
        commentList.setLayoutManager(layoutManager);
        commentList.setOnFlingListener(snapHelper);
        adpater=new CommentAdapter(list,getContext());
        commentList.setAdapter(adpater);
        find=root.findViewById(R.id.find);
        find.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i== EditorInfo.IME_ACTION_SEARCH) {
                    String text=textView.getText().toString();
                    List<CommentItem.MsgBean> templist = new ArrayList<>();
                    for(int j=0;j<list.size();j++){
                        if(list.get(j).getConmmentText().contains(text)){
                            templist.add(list.get(j));
                        }
                    }
                    System.out.println(templist.size());
                    adpater=new CommentAdapter(templist,getContext());
                    commentList.setAdapter(adpater);
                }
                return false;
            }
        });
        final SwipeRefreshLayout swip_refresh_layout=root.findViewById(R.id.swipeLayout);
        swip_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                get_comments();
                swip_refresh_layout.setRefreshing(false);
            }
        });
        publish=root.findViewById(R.id.publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CommentActivity.class);
                startActivity(intent);
            }
        });

        get_comments();
    }
    private void get_comments(){
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
                .url(doUrl.dogetComment)
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
                System.out.println(json);
                Message message = new Message();
                try {
                    JSONObject jsonObject=new JSONObject(json);
                    if(jsonObject.getInt("code")==200){
                        message.what=200;
                        Gson gson = new Gson();
                        CommentItem commentItem = gson.fromJson(json, CommentItem.class);
                        list=commentItem.getMsg();
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