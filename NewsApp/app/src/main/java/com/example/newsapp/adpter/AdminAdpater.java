package com.example.newsapp.adpter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.activity.admin.AdminUpdateActivity;
import com.example.newsapp.pojo.NewsItem;
import com.example.newsapp.util.Token_session;
import com.example.newsapp.util.doUrl;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AdminAdpater extends ArrayAdapter<NewsItem.MsgBean> {
    private int resourceid;
    private Context context;
    private List<NewsItem.MsgBean> list;

    public AdminAdpater(@NonNull Context context, int resource, @NonNull List<NewsItem.MsgBean> objects) {
        super(context, resource, objects);
        this.context=context;
        resourceid=resource;
        list = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final NewsItem.MsgBean newsItem=getItem(position);
        View view;
        AdminAdpater.ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
            holder = new AdminAdpater.ViewHolder();
            holder.pic=view.findViewById(R.id.pic);
            holder.title = view.findViewById(R.id.title);
            holder.text = view.findViewById(R.id.text);
            holder.delete=view.findViewById(R.id.delete);
            holder.update=view.findViewById(R.id.update);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (AdminAdpater.ViewHolder) view.getTag();
        }
        System.out.println(newsItem.getNewsImg());
        Glide.with(context).load(newsItem.getNewsImg().split(",")[0]).into(holder.pic);
        holder.title.setText(newsItem.getNewsTitle());
        holder.text.setText(newsItem.getNewsText());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
                delete_news(String.valueOf(newsItem.getNewsId()));
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatenews(String.valueOf(newsItem.getNewsId()));
            }
        });
        return view;
    }

    class ViewHolder{
        ImageView pic;
        TextView title;
        TextView text;
        Button update;
        Button delete;
    }
    private void delete_news(String id){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .callTimeout(6, TimeUnit.MINUTES)
                .connectTimeout(6, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("token_session", Token_session.getSuperToken())
                .add("id",id)
                .build();
        Request request=new Request.Builder()
                .url(doUrl.dodeletenews)
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
            }
        });
    }
    private void updatenews(String id){
        Intent intent = new Intent(context, AdminUpdateActivity.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }
}

