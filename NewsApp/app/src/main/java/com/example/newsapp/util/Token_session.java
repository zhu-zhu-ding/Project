package com.example.newsapp.util;

import android.content.Context;
import android.content.SharedPreferences;


public class Token_session {
    private static String token_session;
    private static String KEY_TOKEN;
    public static void cacheToken(Context context, String token){
        SharedPreferences.Editor e = context.getSharedPreferences(token_session,context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN, token);
        e.apply();
    }
    public static String getCachedToken(Context context){
        return context.getSharedPreferences(token_session, context.MODE_PRIVATE).getString(KEY_TOKEN, null);
    }
    public static String getSuperToken(){
        return "super";
    }
    public static void clearToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(token_session, context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}
