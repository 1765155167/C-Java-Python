package com.hqf.lsbtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

public class MapViewActivity extends AppCompatActivity {
    private static final String TAG = "MapViewActivity";
    private MapView mapView;
    private BaiduMap baiduMap;
    public LocationClient locationClient;
    private boolean isFirstLocate = true;
    private TextView mapTest;

    public static void actionStart(Context context, double latitude, double longitude) {
        Intent intent = new Intent(context, MapViewActivity.class);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        Toast.makeText(this, "MapViewActivity onCreate", Toast.LENGTH_SHORT).show();
        SDKInitializer.initialize(getApplicationContext());

        mapTest = (TextView) findViewById(R.id.map_text);
        mapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);//使能显示我的位置

        locationClient = new LocationClient(getApplicationContext());
        locationClient.registerLocationListener(new MyLocationListener());
        MainActivity.initLocation(locationClient);
        locationClient.start();

        //获取经纬度
        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);
        navigateTo(latitude, longitude);
    }

    //更改我在地图上的位置
    private void navigateTo(double latitude, double longitude) {
        if (isFirstLocate) {
            LatLng latLng = new LatLng(latitude, longitude);
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(latLng);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomBy(5.5f);//缩放级别3-19值越大地图越精细
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }
        StringBuilder info = new StringBuilder();
        info.append("纬度：").append(latitude).append(" ");
        info.append("经度：").append(longitude);
        mapTest.setText(info);
        //将“我的位置”显示到地图上
        MyLocationData.Builder builder = new MyLocationData.Builder();
        builder.latitude(latitude);
        builder.longitude(longitude);
        baiduMap.setMyLocationData(builder.build());
    }

    /**
     * 实现定位回调
     */
    private class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            int errorCode = bdLocation.getLocType();
            if (errorCode == BDLocation.TypeNetWorkLocation
                    || errorCode == BDLocation.TypeGpsLocation) {
                navigateTo(bdLocation.getLatitude(), bdLocation.getLongitude());
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MapViewActivity onDestroy", Toast.LENGTH_SHORT).show();
        locationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
}
