package com.jwxxjs.clgl.login;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jwxxjs.clgl.mvp.BasePresenterImpl;
import com.jwxxjs.clgl.utils.ApiUtils;
import com.jwxxjs.clgl.vehicleinfo.VehicleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter{
    List<UserModel> mUserModels;


    @Override
    public int login(String userName, String password) {
        int ret = -1;
        if(userName.equals("admin") &&  password.equals("admin")){
            ret = 0;
        }


        return ret;
    }

    @Override
    public List<UserModel> getAccountData() {
        Gson gson = new Gson();
        mUserModels = new ArrayList<>();

        String json = ApiUtils.getAccount();
        mUserModels = gson.fromJson(json,new TypeToken<List<UserModel>>(){}.getType());
        return mUserModels;
    }

    @Override
    public void rememberPassword(String pwd) {

    }

    @Override
    public void forgotPassword() {

    }


    @Override
    public void accountVerify(String userName, String password) {

    }
}
