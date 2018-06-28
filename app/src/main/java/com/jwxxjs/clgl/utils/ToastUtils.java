package com.jwxxjs.clgl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.jwxxjs.clgl.mvp.ClglApp;


/**
 * Created by zcl on 2018/1/10.
 *
 * @link
 * @description
 */

public class ToastUtils {
    public static void showShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context context,int resId){
        Toast.makeText(context,resId,Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context,int resId){
        Toast.makeText(context,resId,Toast.LENGTH_LONG).show();
    }

    public static void shortToast(final String text){
        new android.os.Handler(Looper.getMainLooper()).post(()->Toast.makeText(ClglApp.getInstance(),text,Toast.LENGTH_SHORT));
    }

    public static void shortToast(final int text){
        new android.os.Handler(Looper.getMainLooper()).post(()->Toast.makeText(ClglApp.getInstance(),text,Toast.LENGTH_SHORT));
    }

    public static void longToast(final int text){
        new android.os.Handler(Looper.getMainLooper()).post(()->Toast.makeText(ClglApp.getInstance(),text,Toast.LENGTH_LONG));
    }

    public static void longToast(final String text){
        new android.os.Handler(Looper.getMainLooper()).post(()->Toast.makeText(ClglApp.getInstance(),text,Toast.LENGTH_LONG));
    }






}
