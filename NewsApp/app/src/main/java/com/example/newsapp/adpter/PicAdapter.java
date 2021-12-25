package com.example.newsapp.adpter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.pojo.CommentItem;

import java.util.List;

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.ViewHolder> {
    private List<String> mDataList;
    private Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageAvatar;
        public ViewHolder(View itemView) {
            super(itemView);
            imageAvatar = (ImageView)itemView.findViewById(R.id.pic);
        }
    }
    public PicAdapter(List<String> listDatas, Context context){
        mDataList = listDatas;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.pic_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String listData = mDataList.get(position);
        if(listData.contains("http")){
            Glide.with(context).load(listData).into(holder.imageAvatar);

        }else{
            holder.imageAvatar.setImageBitmap(BitmapFactory.decodeFile(listData));
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
