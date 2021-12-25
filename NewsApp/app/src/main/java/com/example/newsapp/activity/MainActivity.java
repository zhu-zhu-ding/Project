package com.example.newsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.fragment.InfoFragment;
import com.example.newsapp.fragment.NewFragment;
import com.example.newsapp.fragment.TalkFragment;
import com.example.newsapp.util.Token_session;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView maintext;
    private TextView talktext;
    private TextView infotext;
    private ImageView mainimg;
    private ImageView talkimg;
    private ImageView infoimg;
    private ImageView curtimg;
    private TextView curttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        View main = findViewById(R.id.main);
        View talk = findViewById(R.id.talk);
        View info = findViewById(R.id.info);
        main.setOnClickListener(this);
        talk.setOnClickListener(this);
        info.setOnClickListener(this);
        mainimg=findViewById(R.id.mainimg);
        talkimg=findViewById(R.id.talkimg);
        infoimg=findViewById(R.id.infoimg);
        maintext=findViewById(R.id.maintext);
        talktext=findViewById(R.id.talktext);
        infotext=findViewById(R.id.infotext);
        mainimg.setSelected(true);
        maintext.setTextColor(Color.parseColor("#1296db"));
        relpaceFragment(new NewFragment());
        curtimg=mainimg;
        curttext=maintext;
    }

    @Override
    public void onClick(View view) {
        curtimg.setSelected(false);
        curttext.setTextColor(Color.parseColor("#000000"));
        switch (view.getId()) {
            case R.id.main:
                mainimg.setSelected(true);
                maintext.setTextColor(Color.parseColor("#1296db"));
                curtimg=mainimg;
                curttext=maintext;
                relpaceFragment(new NewFragment());
                break;
            case R.id.talk:
                talkimg.setSelected(true);
                talktext.setTextColor(Color.parseColor("#1296db"));
                curtimg=talkimg;
                curttext=talktext;
                relpaceFragment(new TalkFragment());
                break;
            case R.id.info:
                infoimg.setSelected(true);
                infotext.setTextColor(Color.parseColor("#1296db"));
                curtimg=infoimg;
                curttext=infotext;
                relpaceFragment(new InfoFragment());
                break;
            default:
                break;
        }
    }
    private void relpaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();
    }
}