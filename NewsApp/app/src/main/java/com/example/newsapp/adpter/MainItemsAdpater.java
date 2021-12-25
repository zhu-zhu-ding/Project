package com.example.newsapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.pojo.NewsItem;
import com.youth.banner.Banner;
import java.util.List;

public class MainItemsAdpater extends ArrayAdapter<NewsItem.MsgBean> {
    private int resourceid;
    private Context context;

    public MainItemsAdpater(@NonNull Context context, int resource, @NonNull List<NewsItem.MsgBean> objects) {
        super(context, resource, objects);
        this.context=context;
        resourceid=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItem.MsgBean newsItem=getItem(position);
        View view;
        MainItemsAdpater.ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
            holder = new MainItemsAdpater.ViewHolder();
            holder.pic=view.findViewById(R.id.pic);
            holder.title = view.findViewById(R.id.title);
            holder.text = view.findViewById(R.id.text);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (MainItemsAdpater.ViewHolder) view.getTag();
        }
        System.out.println(newsItem.getNewsImg());
        Glide.with(context).load(newsItem.getNewsImg().split(",")[0]).into(holder.pic);
        holder.title.setText(newsItem.getNewsTitle());
        holder.text.setText(newsItem.getNewsText());
        return view;
    }

    class ViewHolder{
        ImageView pic;
        TextView title;
        TextView text;
    }
}

