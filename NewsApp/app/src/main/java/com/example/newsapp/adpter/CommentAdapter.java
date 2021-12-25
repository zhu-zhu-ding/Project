package com.example.newsapp.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.pojo.CommentItem;

import java.util.Arrays;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<CommentItem.MsgBean> mDataList;
    private Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView publisher;
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.comment_pics);
            publisher=itemView.findViewById(R.id.publisher);
            text=itemView.findViewById(R.id.text);
        }
    }
    public CommentAdapter(List<CommentItem.MsgBean> listDatas, Context context){
        mDataList = listDatas;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.comments_adpater_layout,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommentItem.MsgBean listData = mDataList.get(position);
        holder.publisher.setText(listData.getCommentPublisher());
        holder.text.setText(listData.getConmmentText());
        String []picurls = listData.getPicUrls().split(",");
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(new PicAdapter(Arrays.asList(picurls),context));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
