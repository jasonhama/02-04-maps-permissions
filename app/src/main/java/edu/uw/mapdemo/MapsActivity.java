package edu.uw.mapdemo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static final LatLng SEATTLE = new LatLng(47.6147628, -122.4759898);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(47.6550, -122.3080);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in UW"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.addMarker(new MarkerOptions()
                .position(SEATTLE)
                .title("HELLO SEATTLE"));

        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(47, -125),
                (new LatLng(47, -127)),
                (new LatLng(49, -127)),
                (new LatLng(49, -125)),
                (new LatLng(47, -125)))
                .width(5)
                .color(Color.RED);
    }





}
