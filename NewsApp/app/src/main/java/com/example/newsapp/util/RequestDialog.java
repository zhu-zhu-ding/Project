package com.example.newsapp.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.newsapp.R;


public class RequestDialog extends Dialog {

    private static RequestDialog requestDialog;
    private TextView textView;
    public RequestDialog(@NonNull Context context) {
        super(context);
    }
    public static RequestDialog getInstance(Context context){
        if(requestDialog==null){
            requestDialog=new RequestDialog(context);
        }
        return requestDialog;
    }

    public RequestDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rlog_layout);
    }
}
