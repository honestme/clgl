package com.jwxxjs.clgl.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jwxxjs.clgl.mvp.ClglApp;

/**
 * Created by zcl on 2018/1/19.
 *
 * @link
 * @description
 */

public class PreferenceUtils {



    public static void putBoolean(String key,boolean value){
        SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static void putString(String key,String value){
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key,value);
        editor.apply();
    }

    public static void putFloat(String key,float value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void putInt(String key,int value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putLong(String key,Long value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void put(String key,String value){
        putString(key, value);
    }

    public static void put(String key,int value){
        putInt(key, value);
    }

    public static void put(String key,float value){
        putFloat(key,value);
    }

    public static void put(String key,Boolean value){
        putBoolean(key,value);
    }

    public static void put(String key,long value){
        putLong(key,value);
    }

    public static String getString(String key, String defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ClglApp.getInstance()).getString(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ClglApp.getInstance()).getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ClglApp.getInstance()).getFloat(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ClglApp.getInstance()).getInt(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ClglApp.getInstance()).getBoolean(key, defValue);
    }

    public static int get(String key,int value){
        return getInt(key,value);
    }

    public static String get(String key,String value){
        return getString(key,value);
    }

    public static float get(String key,float value){
        return getFloat(key,value);
    }

    public static void remove(String... keys){
        if(keys != null){
            SharedPreferences.Editor editor = getEditor();
            for(String key:keys){
                editor.remove(key);
            }
            editor.apply();
        }
    }

    private static SharedPreferences.Editor getEditor(){
        SharedPreferences.Editor editor = getEditor();
        return editor;
    }
}
