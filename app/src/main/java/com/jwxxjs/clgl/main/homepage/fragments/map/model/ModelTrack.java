package com.jwxxjs.clgl.main.homepage.fragments.map.model;

/**
 * Created by zhengyijing on 2017/11/28.
 */

public class ModelTrack {
    int DTypeEnum;
    String Id;
    String Code;
    String StartTime;
    String EndTime;
    double Longitude;
    double Latitude;
    float Elevation;
    float Speed;
    int Direction;
    float Distance;
    String Status;
    String Warning;
    String AppendInfo;
    String PId;
    int DType;

    public void setDTypeEnum(int DTypeEnum) {
        this.DTypeEnum = DTypeEnum;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public void setElevation(float elevation) {
        Elevation = elevation;
    }

    public void setSpeed(float speed) {
        Speed = speed;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setWarning(String warning) {
        Warning = warning;
    }

    public void setAppendInfo(String appendInfo) {
        AppendInfo = appendInfo;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public void setDType(int DType) {
        this.DType = DType;
    }

    public int getDTypeEnum() {
        return DTypeEnum;
    }

    public String getId() {
        return Id;
    }

    public String getCode() {
        return Code;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public double getLongitude() {
        return Longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public float getElevation() {
        return Elevation;
    }

    public float getSpeed() {
        return Speed;
    }

    public int getDirection() {
        return Direction;
    }

    public float getDistance() {
        return Distance;
    }

    public String getStatus() {
        return Status;
    }

    public String getWarning() {
        return Warning;
    }

    public String getAppendInfo() {
        return AppendInfo;
    }

    public String getPId() {
        return PId;
    }

    public int getDType() {
        return DType;
    }
}
