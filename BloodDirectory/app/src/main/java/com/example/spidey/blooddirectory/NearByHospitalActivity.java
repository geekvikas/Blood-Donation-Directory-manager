package com.example.spidey.blooddirectory;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NearByHospitalActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    GPSTracker gps,gps1,gps2,gps3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_hospital);
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        gps=new GPSTracker(NearByHospitalActivity.this);
        MarkerOptions marker=new MarkerOptions();
        marker.position(new LatLng(gps.getLatitude(),gps.getLongitude()));
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone));
        marker.title("You");
        mMap.addMarker(marker);

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(new LatLng(gps.getLatitude(),gps.getLongitude()),13);
        mMap.animateCamera(location);


        gps1=new GPSTracker(NearByHospitalActivity.this);
        MarkerOptions marker1=new MarkerOptions();
        marker1.position(new LatLng(gps.getLatitude()+0.01,gps.getLongitude()+0.01));
        marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone));
        marker1.title("City Hospital");
        mMap.addMarker(marker1);

        gps2=new GPSTracker(NearByHospitalActivity.this);
        MarkerOptions marker2=new MarkerOptions();
        marker2.position(new LatLng(gps.getLatitude()-0.01,gps.getLongitude()-0.01));
        marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone));
        marker2.title("Divine Hospital");
        mMap.addMarker(marker2);

        gps3=new GPSTracker(NearByHospitalActivity.this);
        MarkerOptions marker3=new MarkerOptions();
        marker3.position(new LatLng(gps.getLatitude()+0.01,gps.getLongitude()-0.01));
        marker3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone));
        marker3.title("Private Clinic");
        mMap.addMarker(marker3);


        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
