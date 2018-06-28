package com.jwxxjs.clgl.main.homepage.fragments.map.model;

/**
 * Created by zheng on 2018/2/7.
 */

public class ModelCars {



    public class SignalModel{
        String ActiveInterval;
        Boolean Active;
        int OnlineStatusEnum;
        String OnlineStatusStr;
        String Id;
        String Name;

        public String getActiveInterval() {
            return ActiveInterval;
        }

        public void setActiveInterval(String activeInterval) {
            ActiveInterval = activeInterval;
        }

        public void setActive(Boolean active) {
            Active = active;
        }

        public void setOnlineStatusEnum(int onlineStatusEnum) {
            OnlineStatusEnum = onlineStatusEnum;
        }

        public void setOnlineStatusStr(String onlineStatusStr) {
            OnlineStatusStr = onlineStatusStr;
        }

        public void setId(String id) {
            Id = id;
        }

        public void setName(String name) {
            Name = name;
        }

        public void setCode(String code) {
            Code = code;
        }

        public void setPhoneNo(String phoneNo) {
            PhoneNo = phoneNo;
        }

        public void setSignalDefineionCode(String signalDefineionCode) {
            SignalDefineionCode = signalDefineionCode;
        }

        public void setVehicleCode(String vehicleCode) {
            VehicleCode = vehicleCode;
        }

        public void setBuildDate(String buildDate) {
            BuildDate = buildDate;
        }

        public void setDestroyDate(String destroyDate) {
            DestroyDate = destroyDate;
        }

        public void setOnVehicleStatus(String onVehicleStatus) {
            OnVehicleStatus = onVehicleStatus;
        }

        public void setIpAddr(String ipAddr) {
            IpAddr = ipAddr;
        }

        public void setPort(String port) {
            Port = port;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public void setMemo(String memo) {
            Memo = memo;
        }

        public void setDisabled(int disabled) {
            Disabled = disabled;
        }

        public void setUpdateTime(String updateTime) {
            UpdateTime = updateTime;
        }

        public void setOnlineStatus(int onlineStatus) {
            OnlineStatus = onlineStatus;
        }

        public void setOnlineTime(String onlineTime) {
            OnlineTime = onlineTime;
        }

        public Boolean getActive() {
            return Active;
        }

        public int getOnlineStatusEnum() {
            return OnlineStatusEnum;
        }

        public String getOnlineStatusStr() {
            return OnlineStatusStr;
        }

        public String getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public String getCode() {
            return Code;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public String getSignalDefineionCode() {
            return SignalDefineionCode;
        }

        public String getVehicleCode() {
            return VehicleCode;
        }

        public String getBuildDate() {
            return BuildDate;
        }

        public String getDestroyDate() {
            return DestroyDate;
        }

        public String getOnVehicleStatus() {
            return OnVehicleStatus;
        }

        public String getIpAddr() {
            return IpAddr;
        }

        public String getPort() {
            return Port;
        }

        public String getUserName() {
            return UserName;
        }

        public String getPassword() {
            return Password;
        }

        public String getMemo() {
            return Memo;
        }

        public int getDisabled() {
            return Disabled;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public int getOnlineStatus() {
            return OnlineStatus;
        }

        public String getOnlineTime() {
            return OnlineTime;
        }

        String Code;
        String PhoneNo;
        String SignalDefineionCode;
        String VehicleCode;
        String BuildDate;
        String DestroyDate;
        String OnVehicleStatus;
        String IpAddr;
        String Port;
        String UserName;
        String Password;
        String Memo;
        int Disabled;
        String UpdateTime;
        int OnlineStatus;
        String OnlineTime;


    }

    public class DataRealTime{
        int OnlineStatus;
        String OnlineStatusStr;
        String Id;
        String Code;

        public void setOnlineStatus(int onlineStatus) {
            OnlineStatus = onlineStatus;
        }

        public void setOnlineStatusStr(String onlineStatusStr) {
            OnlineStatusStr = onlineStatusStr;
        }

        public void setId(String id) {
            Id = id;
        }

        public void setCode(String code) {
            Code = code;
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

        public void setElevation(double elevation) {
            Elevation = elevation;
        }

        public void setSpeed(double speed) {
            Speed = speed;
        }

        public void setDirection(int direction) {
            Direction = direction;
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

        public int getOnlineStatus() {
            return OnlineStatus;
        }

        public String getOnlineStatusStr() {
            return OnlineStatusStr;
        }

        public String getId() {
            return Id;
        }

        public String getCode() {
            return Code;
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

        public double getElevation() {
            return Elevation;
        }

        public double getSpeed() {
            return Speed;
        }

        public int getDirection() {
            return Direction;
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

        String EndTime;
        double Longitude;
        double Latitude;
        double Elevation;
        double Speed;
        int Direction;
        String Status;
        String Warning;
        String AppendInfo;
        String PId;

    }

    Boolean SignalValid;
    int OnlineStatus;
    int PlateColorEnum;
    String PlateColorStr;
    String Id;
    String VehicleCode;
    String PlateNumber;
    String PlateColor;
    String OrganizeEnCode;
    String AreaCode;
    String PurchasingTime;
    String NetTime;

    public void setSignalValid(Boolean signalValid) {
        SignalValid = signalValid;
    }

    public void setOnlineStatus(int onlineStatus) {
        OnlineStatus = onlineStatus;
    }

    public void setPlateColorEnum(int plateColorEnum) {
        PlateColorEnum = plateColorEnum;
    }

    public void setPlateColorStr(String plateColorStr) {
        PlateColorStr = plateColorStr;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setVehicleCode(String vehicleCode) {
        VehicleCode = vehicleCode;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public void setPlateColor(String plateColor) {
        PlateColor = plateColor;
    }

    public void setOrganizeEnCode(String organizeEnCode) {
        OrganizeEnCode = organizeEnCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public void setPurchasingTime(String purchasingTime) {
        PurchasingTime = purchasingTime;
    }

    public void setNetTime(String netTime) {
        NetTime = netTime;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public void setChassisNumber(String chassisNumber) {
        ChassisNumber = chassisNumber;
    }

    public void setEngineNo(String engineNo) {
        EngineNo = engineNo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public void setSignalModel(ModelCars.SignalModel signalModel) {
        SignalModel = signalModel;
    }

    public void setDataRealTime(ModelCars.DataRealTime dataRealTime) {
        DataRealTime = dataRealTime;
    }

    public Boolean getSignalValid() {

        return SignalValid;
    }

    public int getOnlineStatus() {
        return OnlineStatus;
    }

    public int getPlateColorEnum() {
        return PlateColorEnum;
    }

    public String getPlateColorStr() {
        return PlateColorStr;
    }

    public String getId() {
        return Id;
    }

    public String getVehicleCode() {
        return VehicleCode;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public String getPlateColor() {
        return PlateColor;
    }

    public String getOrganizeEnCode() {
        return OrganizeEnCode;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public String getPurchasingTime() {
        return PurchasingTime;
    }

    public String getNetTime() {
        return NetTime;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public String getChassisNumber() {
        return ChassisNumber;
    }

    public String getEngineNo() {
        return EngineNo;
    }

    public String getMemo() {
        return Memo;
    }

    public ModelCars.SignalModel getSignalModel() {
        return SignalModel;
    }

    public ModelCars.DataRealTime getDataRealTime() {
        return DataRealTime;
    }

    String ApplicationType;
    String VehicleType;
    String ChassisNumber;
    String EngineNo;
    String Memo;


    SignalModel SignalModel;
    DataRealTime DataRealTime;
}
