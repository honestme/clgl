package com.jwxxjs.clgl.login;

/**
 * Created by Administrator on 2017/11/6 0006.
 *
 * @link
 * @description
 */

public class UserModel {
    private String mUserName;
    private String mPhoneNumber;
    private String mPwd;
    private String mUserId;

    public UserModel(String mUserName, String mPhoneNumber, String mPwd, String mUserId) {
        this.mUserName = mUserName;
        this.mPhoneNumber = mPhoneNumber;
        this.mPwd = mPwd;
        this.mUserId = mUserId;
    }


    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd;
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }
}
