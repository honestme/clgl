package com.jwxxjs.clgl.utils;

import java.io.IOError;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zcl on 2018/3/30.
 *
 * @link
 * @description
 */

public class ApiUtils {
    public static String API_ALERT_URL = "";
    public static String API_VEHICLE_URL = "http://218.28.180.70:3692/api/vehicles?towncode=410182&code=";
    public static String API_ACCOUNT_URL = "";

    public static String getUrlData(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return "";
    }

    public static String getAlert(){
        return getUrlData(API_ALERT_URL);
    }

    public static String getVehicle(){
        return getUrlData(API_VEHICLE_URL);
    }

    public static String getAccount(){
        return getUrlData(API_ACCOUNT_URL);
    }

}
