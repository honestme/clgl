package com.jwxxjs.clgl.main.homepage.fragments.map;


import com.jwxxjs.clgl.main.homepage.fragments.map.model.ModelCars;
import com.jwxxjs.clgl.main.homepage.fragments.map.model.ModelTrack;

import java.util.ArrayList;

/**
 * Created by zhengyijing on 2017/11/30.
 */

public class DataSourceHelper {


    //车辆模型数据库
    ArrayList<ModelCars> carsDataSource;
    //轨迹存储库
    ArrayList<ModelTrack> traceDataSource;


    //懒加载
    public ArrayList<ModelTrack> getTraceDataSource() {
        if (traceDataSource == null){ 
            traceDataSource = new ArrayList<ModelTrack>();
        }
        return traceDataSource;
    }

    public void setTraceDataSource(ArrayList<ModelTrack> traceDataSource) {
        this.traceDataSource = traceDataSource;
    }

    public void setCarsDataSource(ArrayList<ModelCars> carsDataSource) {

        this.carsDataSource = carsDataSource;
    }

    public ArrayList<ModelCars> getCarsDataSource() {
        if (carsDataSource == null){
            carsDataSource = new ArrayList<ModelCars>();
        }
        return carsDataSource;
    }

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static DataSourceHelper instance = null;

    /* 私有构造方法，防止被实例化 */
    private DataSourceHelper() {
    }

    /* 1:懒汉式，静态工程方法，创建实例 */
    public static DataSourceHelper getInstance() {
        if (instance == null) {
            instance = new DataSourceHelper();
        }
        return instance;
    }
}
