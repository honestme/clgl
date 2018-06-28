package com.jwxxjs.clgl.alert;

/**
 * Created by Administrator on 2017/11/29 0029.
 *
 * @link
 * @description
 */

public class AlertItem {
    String mAlertTitle;
    String mAlertLevel;
    String mAlertDetail;

    public AlertItem(String mAlertTitle, String mAlertLevel, String mAlertDetail) {
        this.mAlertTitle = mAlertTitle;
        this.mAlertLevel = mAlertLevel;
        this.mAlertDetail = mAlertDetail;
    }

    public String getmAlertTitle() {
        return mAlertTitle;
    }

    public void setmAlertTitle(String mAlertTitle) {
        this.mAlertTitle = mAlertTitle;
    }

    public String getmAlertLevel() {
        return mAlertLevel;
    }

    public void setmAlertLevel(String mAlertLevel) {
        this.mAlertLevel = mAlertLevel;
    }

    public String getmAlertDetail() {
        return mAlertDetail;
    }

    public void setmAlertDetail(String mAlertDetail) {
        this.mAlertDetail = mAlertDetail;
    }
}