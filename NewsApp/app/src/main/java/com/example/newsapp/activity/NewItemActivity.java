package com.example.newsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;

public class NewItemActivity extends AppCompatActivity {

    private TextView title;
    private TextView text;
    private ImageView pic1;
    private ImageView pic2;
    private ImageView pic3;
    private TextView publisher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        init();
    }
    private void init(){
        title=findViewById(R.id.title);
        text=findViewById(R.id.text);
        pic1=findViewById(R.id.pic1);
        pic2=findViewById(R.id.pic2);
        pic3=findViewById(R.id.pic3);
        publisher=findViewById(R.id.publisher);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        text.setText(intent.getStringExtra("text"));
        String pic1url = intent.getStringExtra("pic1url");
        String pic2url = intent.getStringExtra("pic2url");
        String pic3url = intent.getStringExtra("pic3url");
        String publisher1 = intent.getStringExtra("publisher");
        publisher.setText("作者:"+publisher1);
        Glide.with(this).load(pic1url).into(pic1);
        Glide.with(this).load(pic2url).into(pic2);
        Glide.with(this).load(pic3url).into(pic3);

    }
}