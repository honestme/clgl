package com.jwxxjs.clgl.main.homepage.fragments.map;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.homepage.fragments.map.model.ModelCars;
import com.jwxxjs.clgl.main.homepage.fragments.map.model.ModelTrack;

import com.jwxxjs.clgl.mvp.MVPBaseFragment;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MapFragment extends MVPBaseFragment<MapContract.View, MapPresenter> implements MapContract.View{

    @BindView(R.id.bmapView)
    MapView mMapView;
    SupportMapFragment map;
    BaiduMap mBaiduMap;
    boolean flag;
    public LocationClient mLocationClient = null;
//    private MyLocationListener myListener = new MyLocationListener();
    //BDAbstractLocationListener为7.2版本新增的Abstract类型的监听接口
    //原有BDLocationListener接口暂时同步保留。具体介绍请参考后文中的说明
    boolean firstLoc = true; //是否首次定位
    Button mapLocationBtn;//位置定位按钮
    Button mapChangeBtn;//地图切换按钮
    Button trackButton; //轨迹查询按钮
    Button trackStartBtn;
    Button trackEndBtn;
    EditText searchEdit;//输入框
    Button searchBtn; // 搜索确认按钮
    ArrayList<LatLng> markerList;//marker集合
    int indexOfSelect; //搜索框值
    static boolean isFirstLoad = true; //是否第一次加载
    static boolean InfoWindowIsActive = false; //弹出窗是否在显示
    static boolean isTrack = false; //初始化轨迹查询状态
//    static TimePickerDialog mTimePickerDialog; //时间选择器全局变量
private TimePickerView pvTime;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



//        new updaThread().start();
//  车辆数据循环更新
        CountDownTimer cdt = new CountDownTimer(100000000, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (!isTrack){
                    initData();
                    initMarker();
                }else {
                    System.out.print("请关闭轨迹查询");
                }


            }
            @Override
            public void onFinish() {

            }
        };

        cdt.start();


        //初始化marklistArr
        if (markerList == null){
            markerList = new ArrayList<LatLng>();

        }
        if (isFirstLoad){
            //网络请求测试
            sendRequestWithOKHttp();
            //时间选择器init

            initTimePicker();



            isFirstLoad = false;
        }




        //        //网络请求测试
//        sendRequestWithOKHttp();

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//切换地图为...
        //获取输入框
        searchEdit = getActivity().findViewById(R.id.mapfragement_searchEditText);
        //获取搜索确认按钮
        searchBtn = getActivity().findViewById(R.id.mapfragment_searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmpValue = searchEdit.getText().toString();
                if("".equals(tmpValue)){
                    indexOfSelect = 0;
                }else {
                    indexOfSelect = Integer.valueOf(tmpValue);

                }
                if (indexOfSelect <= DataSourceHelper.getInstance().getCarsDataSource().size()){
                    ModelCars car = DataSourceHelper.getInstance().getCarsDataSource().get(indexOfSelect);

                    //设定中心点坐标
                    LatLng cenpt = new LatLng(car.getDataRealTime().getLatitude(),car.getDataRealTime().getLongitude());
                    //定义地图状态
                    MapStatus mMapStatus = new MapStatus.Builder()
                            .target(cenpt)
                            .zoom(21)
                            .build();
                    //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化

                    MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                    //改变地图状态
                    mBaiduMap.setMapStatus(mMapStatusUpdate);
                }


            }
        });
        //获得位置定位按钮
        mapLocationBtn = getActivity().findViewById(R.id.mapfragment_location);
        mapLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                initData();
//                initMarker();

            }
        });


        //获得地图切换按钮。
        mapChangeBtn = getActivity().findViewById(R.id.mapfragment_changeMap);
        mapChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //切换地图状态
                if (flag) {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//切换地图为道路地图
                    flag = false;
                } else {
                    mBaiduMap = mMapView.getMap();
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);//切换地图为卫星地图
                    flag = true;

                }
            }
        });

        //获得轨迹查询按钮
        trackButton = getActivity().findViewById(R.id.mapfragment_track);
        trackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTrack){
                    trackRequet();
                    isTrack = true;

                }else {
                    initData();
                    initMarker();
                    isTrack = false;
                }



            }
        });

        //获得轨迹查询起始
        trackStartBtn = getActivity().findViewById(R.id.mapfragment_trackStart);
        trackStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //时间选择器
                                pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
            }
        });
        //获得轨迹查询结束
        trackEndBtn = getActivity().findViewById(R.id.mapfragment_trackEnd);
        trackEndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //时间选择器
                                pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
            }
        });





        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                LatLng lltext = marker.getPosition();
//
                //创建InfoWindow展示的view
                TextView textView = new TextView(getActivity().getApplication().getApplicationContext());
                textView.setBackgroundResource(R.drawable.wlqq_popup_window_bg);
                ModelCars car = DataSourceHelper.getInstance().getCarsDataSource().get(markerList.indexOf(lltext));
                String text = ("车辆编号：" + String.valueOf(car.getId()) +"\n");
                text += ("车牌号码：" + car.getPlateNumber() +"\n");
                text += ("入网时间：" + car.getNetTime() + "\n");
                text += ("位    置：" + "E " + car.getDataRealTime().getLatitude() + "N " + car.getDataRealTime().getLongitude() + "\n");
                text += ("网络状态：" + car.getDataRealTime().getOnlineStatusStr() + "\n");
                text += ("车辆状态：" + car.getSignalModel().getActive().toString() + "\n");
                text += ("司乘人员：" + car.getApplicationType() + "\n");
//                text += "车辆轨迹";
                textView.setText(text);
                textView.setTextColor(R.color.color_primary_dark);


//定义用于显示该InfoWindow的坐标点
                LatLng pt = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);

//创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
                InfoWindow mInfoWindow = new InfoWindow(textView, pt, -47);

//显示InfoWindow
                if (!InfoWindowIsActive){
                    mBaiduMap.showInfoWindow(mInfoWindow);
                    InfoWindowIsActive = true;
                }else {
                    mBaiduMap.hideInfoWindow();
                    InfoWindowIsActive = false;

                }

                return false;
            }
        });

    }


//    //时间选择器监听接口
//

    //时间选择器
    private void initTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2000, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2050, 11, 28);
        //时间选择器
        pvTime = new TimePickerView.Builder(getContext(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                Button btn = (Button) v;
                btn.setText(getTime(date));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                //                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setDecorView(null)
                .build();
    }
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
//    //时间选择器----------确定
    //选择器监听接口

    //轨迹网络请求
    void trackRequet(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    indexOfSelect = Integer.valueOf(searchEdit.getText().toString());
                    ModelCars car = DataSourceHelper.getInstance().getCarsDataSource().get(indexOfSelect);
                    String towncode = "410182";
                    String code =  car.getVehicleCode();
                    String from = trackStartBtn.getText().toString();
                    String to = trackEndBtn.getText().toString();
                    from = from.replaceAll("[^0-9a-zA-Z]","");
//                    from = from.substring(0,from.length()-2);
                    to = to.replaceAll("[^0-9a-zA-Z]","");
//                    to = to.substring(0,to.length()-2);
                    String trackUrl = "http://192.168.2.6:3692/api/track?" + "towncode=" + towncode + "&" + "code=" + code + "&" + "from=" + from + "&" + "to=" + to;
                    Log.d("999999", trackUrl);

                    OkHttpClient client = new OkHttpClient();
                    //http://192.168.2.6:3692/api/track?towncode=410182&code=A19999&from=201801121730&to=201801122130;
                    Request request = new Request.Builder().url(trackUrl).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    initDataSource(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //轨迹网络请求

    //轨迹初始化
    void initDataSource(String trackJsonData) {
        //Gson
        Gson gson = new Gson();
        List<ModelTrack> trackArr  = gson.fromJson(trackJsonData, new TypeToken<List<ModelTrack>>() {
        }.getType());
        DataSourceHelper.getInstance().getTraceDataSource().clear();
        //JsonObj
        try {
            for (int i = 0; i < trackArr.size(); i++) {
                //
                ModelTrack track = trackArr.get(i);


                // 将GPS设备采集的原始GPS坐标转换成百度坐标

                CoordinateConverter converter  = new CoordinateConverter();
                converter.from(CoordinateConverter.CoordType.GPS);

                // sourceLatLng待转换坐标
                LatLng llText = new LatLng(track.getLatitude(), track.getLongitude());

                converter.coord(llText);
                LatLng desLatLng = converter.convert();
                track.setLatitude(desLatLng.latitude);
                track.setLongitude(desLatLng.longitude);
                //单例取到数组
                DataSourceHelper.getInstance().getTraceDataSource().add(track);
                //
                if (i == (trackArr.size()-1)){
                    initTrack();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //更新数据
    void initTrack(){
        //        初始化数据
        mBaiduMap.clear();
        //在地图上标记出查询的车辆信息



        List<LatLng> points = new ArrayList<LatLng>();

        for (int i = 0; i < DataSourceHelper.getInstance().getTraceDataSource().size(); i++) {
            ModelTrack track = DataSourceHelper.getInstance().getTraceDataSource().get(i);
            LatLng p = new LatLng(track.getLatitude(), track.getLongitude());
            points.add(p);

        }

        //绘制折线
        OverlayOptions ooPolyline = new PolylineOptions().width(10)
                .color(0xAAFF0000).points(points);
       Polyline mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
    }



    void initMarker() {

//        初始化数据
        markerList.clear();
        mBaiduMap.clear();

        //2.创建多个点
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.car000);


        //创建OverlayOptions的集合

        List<OverlayOptions> options = new ArrayList<OverlayOptions>();
//设置坐标点
        for (int i = 0; i < DataSourceHelper.getInstance().getCarsDataSource().size(); i++) {
            ModelCars car = DataSourceHelper.getInstance().getCarsDataSource().get(i);
            LatLng point = new LatLng(car.getDataRealTime().getLatitude(), car.getDataRealTime().getLongitude());
            markerList.add(point);


/*定义车辆文字*/

            //定义文字所显示的坐标点
            LatLng llText = new LatLng(car.getDataRealTime().getLatitude(), car.getDataRealTime().getLongitude());


//构建文字Option对象，用于在地图上添加文字
            OverlayOptions textOption = new TextOptions()
                    .bgColor(Color.parseColor("#5CACEE"))
                    .fontSize(24)
                    .fontColor(Color.parseColor("#141414"))
                    .text("车辆编号：" + car.getId())
                    .rotate(-0)
                    .position(llText);

//在地图上添加该文字对象并显示
            mBaiduMap.addOverlay(textOption);

//创建OverlayOptions属性
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap);
            if (options.indexOf(option) == -1){
                options.add(option);

            }


        }
        mBaiduMap.addOverlays(options);

    }


    //初始化定位数据
    void initData() {


//        MapStatusUpdate update = MapStatusUpdateFactory.zoomTo(21);
//        mBaiduMap.setMapStatus(update);

        mBaiduMap.setMyLocationEnabled(true);//开启定位图层
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(mLocationClientListener);//注册监听函数

        //配置
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，设置定位模式，默认高精度
        //LocationMode.Hight_Accuracy：高精度；
        //LocationMode. Battery_Saving：低功耗；
        //LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("gcj02");
        //可选，设置返回经纬度坐标类型，默认gcj02
        //gcj02：国测局坐标；
        //bd09ll：百度经纬度坐标；
        //bd09：百度墨卡托坐标；
        //海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标

        option.setScanSpan(1000);
        //可选，设置发起定位请求的间隔，int类型，单位ms
        //如果设置为0，则代表单次定位，即仅定位一次，默认为0
        //如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
        //可选，设置是否使用gps，默认false
        //使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
        //可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
        //可选，定位SDK内部是一个service，并放到了独立进程。
        //设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
        //可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5 * 60 * 1000);
        //可选，7.2版本新增能力
        //如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位

        option.setEnableSimulateGps(false);
        //可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

        mLocationClient.setLocOption(option);
        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

        mLocationClient.start();
        //mLocationClient为第二步初始化过的LocationClient对象
        //调用LocationClient的start()方法，便可发起定位请求
        // 构造定位数据
//        MyLocationData locData = new MyLocationData.Builder()
//                .accuracy(10)
//                // 此处设置开发者获取到的方向信息，顺时针0-360
//                .direction(100).latitude(113.7164273)
//                .longitude(34.7716082).build();
////
//// 设置定位数据
//        mBaiduMap.setMyLocationData(locData);

        //设置自定义图标
        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory.fromResource(R.drawable
                .icon_geo);
        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration
                .LocationMode.NORMAL, true, mCurrentMarker);
        mBaiduMap.setMyLocationConfiguration(config);


    }

    //定位监听
    private BDLocationListener mLocationClientListener = new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation == null)
                return;

            float accuracy = bdLocation.getRadius();
            double lat = bdLocation.getLatitude();
            double lon = bdLocation.getLongitude();

            MyLocationData.Builder build = new MyLocationData.Builder();
            build.accuracy(accuracy);
            build.latitude(lat);
            build.longitude(lon);
//            //模拟定位数据
//            build.latitude(113.7164273);
//            build.longitude(34.7716082);
            MyLocationData myLocationData = build.build();
            mBaiduMap.setMyLocationData(myLocationData);//设置定位数据

            if (firstLoc) {
                firstLoc = false;

                MapStatus.Builder mapStatusBuilder = new MapStatus.Builder();
                LatLng ll = new LatLng(lat, lon);
                mapStatusBuilder.target(ll);
                mapStatusBuilder.zoom(18.0f);

                MapStatus mapStatus = mapStatusBuilder.build();
                MapStatusUpdate mapUpdate = MapStatusUpdateFactory
                        .newMapStatus(mapStatus);
                mBaiduMap.animateMapStatus(mapUpdate);

            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void finishCreateView(Bundle state) {

    }

    @NonNull

    @Override
    public MapPresenter createPresenter() {
        return new MapPresenter();
    }

    @Override
    protected void initAllMembers(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_map;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestro
        // y()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理 
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();

    }

//=====
//车辆列表网络请求
private void sendRequestWithOKHttp() {
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("http://218.28.180.70:3692/api/vehicles?towncode=410182&code=").build();
                Response response = client.newCall(request).execute();
                String responseData = response.body().string();
                parseJSONWithGSON(responseData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}

    private void parseJSONWithGSON(String jsonData) {

        //Gson
        Gson gson = new Gson();
        List<ModelCars> CarArr  = gson.fromJson(jsonData, new TypeToken<List<ModelCars>>() {
        }.getType());
        //单例取到数组
        DataSourceHelper.getInstance().getCarsDataSource();
//        //JsonObj
        try {
//            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < CarArr.size(); i++) {
//
                ModelCars car = CarArr.get(i);


                // 将GPS设备采集的原始GPS坐标转换成百度坐标

                CoordinateConverter converter  = new CoordinateConverter();
                converter.from(CoordinateConverter.CoordType.GPS);

                // sourceLatLng待转换坐标
                LatLng llText = new LatLng(car.getDataRealTime().getLatitude(), car.getDataRealTime().getLongitude());

                converter.coord(llText);
                LatLng desLatLng = converter.convert();
                car.getDataRealTime().setLatitude(desLatLng.latitude);
                car.getDataRealTime().setLongitude(desLatLng.longitude);
                //单例取到数组
                DataSourceHelper.getInstance().getCarsDataSource().add(car);
//
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
