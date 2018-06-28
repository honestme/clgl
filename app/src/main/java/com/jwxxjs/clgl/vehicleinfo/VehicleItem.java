package com.jwxxjs.clgl.vehicleinfo;

/**
 * Created by zcl on 2018/3/28.
 *
 * @link
 * @description
 */

public class VehicleItem {

    private SignalModel SignalModel;
    private DataRealTime DataRealTime;
    boolean SignalValid;
    int OnlineStatus;
    int PlateColorEnum;
    String PlateColorStr;
    String Id;
    String VehicleCode;
    String PlateNumber;
    String PlateColor;
    String OrganizeId;
    String AreaCode;
    String PurchasingTime;
    String NetTime;
    String ApplicationType;
    String VehicleType;
    String Brand;
    String JingDi;
    String FengLiu;
    String ChassisNumber;
    String EngineNo;
    String Memo;


    public class SignalModel {
        String ActiveInterval;
        boolean Active;
        int OnlineStatusEnum;
        String Name;
        String PhoneNo;
        String SignalDefineionCode;
        String BuildDate;
        String DestroyDate;
        String OnVehicleStatus;
        String IpAddr;
        String Port;
        String UserName;
        String Password;
        int Disabled;
        String UpdateTime;
        String OnlineTime;


        public String getActiveInterval() {
            return ActiveInterval;
        }

        public void setActiveInterval(String activeInterval) {
            ActiveInterval = activeInterval;
        }

        public boolean isActive() {
            return Active;
        }

        public void setActive(boolean active) {
            Active = active;
        }

        public int getOnlineStatusEnum() {
            return OnlineStatusEnum;
        }

        public void setOnlineStatusEnum(int onlineStatusEnum) {
            OnlineStatusEnum = onlineStatusEnum;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            PhoneNo = phoneNo;
        }

        public String getSignalDefineionCode() {
            return SignalDefineionCode;
        }

        public void setSignalDefineionCode(String signalDefineionCode) {
            SignalDefineionCode = signalDefineionCode;
        }

        public String getBuildDate() {
            return BuildDate;
        }

        public void setBuildDate(String buildDate) {
            BuildDate = buildDate;
        }

        public String getDestroyDate() {
            return DestroyDate;
        }

        public void setDestroyDate(String destroyDate) {
            DestroyDate = destroyDate;
        }

        public String getOnVehicleStatus() {
            return OnVehicleStatus;
        }

        public void setOnVehicleStatus(String onVehicleStatus) {
            OnVehicleStatus = onVehicleStatus;
        }

        public String getIpAddr() {
            return IpAddr;
        }

        public void setIpAddr(String ipAddr) {
            IpAddr = ipAddr;
        }

        public String getPort() {
            return Port;
        }

        public void setPort(String port) {
            Port = port;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public int getDisabled() {
            return Disabled;
        }

        public void setDisabled(int disabled) {
            Disabled = disabled;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String updateTime) {
            UpdateTime = updateTime;
        }

        public String getOnlineTime() {
            return OnlineTime;
        }

        public void setOnlineTime(String onlineTime) {
            OnlineTime = onlineTime;
        }
    }

    public class DataRealTime {
        int OnLineStatus;
        String OnlineStatusStr;
        String Code;
        String EndTime;
        float Longitude;
        float Latitude;
        float Elevation;
        float Speed;
        int Direction;
        String Status;
        String Warning;
        String AppendInfo;
        String PId;

        public int getOnLineStatus() {
            return OnLineStatus;
        }

        public void setOnLineStatus(int onLineStatus) {
            OnLineStatus = onLineStatus;
        }

        public String getOnlineStatusStr() {
            return OnlineStatusStr;
        }

        public void setOnlineStatusStr(String onlineStatusStr) {
            OnlineStatusStr = onlineStatusStr;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String endTime) {
            EndTime = endTime;
        }

        public float getLongitude() {
            return Longitude;
        }

        public void setLongitude(float longitude) {
            Longitude = longitude;
        }

        public float getLatitude() {
            return Latitude;
        }

        public void setLatitude(float latitude) {
            Latitude = latitude;
        }

        public float getElevation() {
            return Elevation;
        }

        public void setElevation(float elevation) {
            Elevation = elevation;
        }

        public float getSpeed() {
            return Speed;
        }

        public void setSpeed(float speed) {
            Speed = speed;
        }

        public int getDirection() {
            return Direction;
        }

        public void setDirection(int direction) {
            Direction = direction;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String getWarning() {
            return Warning;
        }

        public void setWarning(String warning) {
            Warning = warning;
        }

        public String getAppendInfo() {
            return AppendInfo;
        }

        public void setAppendInfo(String appendInfo) {
            AppendInfo = appendInfo;
        }

        public String getPId() {
            return PId;
        }

        public void setPId(String PId) {
            this.PId = PId;
        }
    }

    public SignalModel getSignalModel() {
        return SignalModel;
    }

    public void setSignalModel(SignalModel signalModel) {
        SignalModel = signalModel;
    }

    public DataRealTime getDataRealTime() {
        return DataRealTime;
    }

    public void setDataRealTime(DataRealTime dataRealTime) {
        DataRealTime = dataRealTime;
    }

    public boolean isSignalValid() {
        return SignalValid;
    }

    public void setSignalValid(boolean signalValid) {
        SignalValid = signalValid;
    }

    public int getOnlineStatus() {
        return OnlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        OnlineStatus = onlineStatus;
    }

    public int getPlateColorEnum() {
        return PlateColorEnum;
    }

    public void setPlateColorEnum(int plateColorEnum) {
        PlateColorEnum = plateColorEnum;
    }

    public String getPlateColorStr() {
        return PlateColorStr;
    }

    public void setPlateColorStr(String plateColorStr) {
        PlateColorStr = plateColorStr;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVehicleCode() {
        return VehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        VehicleCode = vehicleCode;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getPlateColor() {
        return PlateColor;
    }

    public void setPlateColor(String plateColor) {
        PlateColor = plateColor;
    }

    public String getOrganizeId() {
        return OrganizeId;
    }

    public void setOrganizeId(String organizeId) {
        OrganizeId = organizeId;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getPurchasingTime() {
        return PurchasingTime;
    }

    public void setPurchasingTime(String purchasingTime) {
        PurchasingTime = purchasingTime;
    }

    public String getNetTime() {
        return NetTime;
    }

    public void setNetTime(String netTime) {
        NetTime = netTime;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getJingDi() {
        return JingDi;
    }

    public void setJingDi(String jingDi) {
        JingDi = jingDi;
    }

    public String getFengLiu() {
        return FengLiu;
    }

    public void setFengLiu(String fengLiu) {
        FengLiu = fengLiu;
    }

    public String getChassisNumber() {
        return ChassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        ChassisNumber = chassisNumber;
    }

    public String getEngineNo() {
        return EngineNo;
    }

    public void setEngineNo(String engineNo) {
        EngineNo = engineNo;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }
}
