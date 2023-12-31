package com.example.maphistory;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MyMapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    MainActivity activity;
    public MyMapFragment()  {
        getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap gmap) {
        this.googleMap = gmap;

        // Set default position
        // Add a marker in Sydney and move the camera
        LatLng vietnam = new LatLng(21.028511, 105.804817); // 14.0583° N, 108.2772° E
        this.googleMap.addMarker(new MarkerOptions().position(vietnam).title("Ha Noi"));
        float defaultZoomLevel = 8.0f;

        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vietnam, defaultZoomLevel));

        List<MarkerOptions> markerOptionsList = getMarkerOptionsList();

        // Iterate over the list and add markers to the map
        for (MarkerOptions markerOptions : markerOptionsList) {
            googleMap.addMarker(markerOptions);
        }

        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + " : "+ latLng.longitude);
                // Clear previously click position.
                googleMap.clear();
                // Zoom the Marker
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                // Add Marker on Map
                googleMap.addMarker(markerOptions);

            }
        });

        this.googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                if (marker.getTitle().equals("Bạch Đằng Giang")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "bachdang");
                    startActivity(intent);

                } else if (marker.getTitle().equals("Dinh Độc Lập")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "chiendichHCM");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Sông Như Nguyệt")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "nhunguyet");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Đông Bộ Đầu")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "dongbodau");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Ải Chi Lăng")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "chilang");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Rạch Gầm - Xoài Mút")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "rachgam");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Gò Đống Đa")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "ngochoi");
                    startActivity(intent);
                } else if (marker.getTitle().equals("Điện Biên Phủ 1954")) {
                    activity = (MainActivity) getActivity();
                    Intent intent =  new Intent(getActivity(), detail.class);
                    intent.putExtra("event", "dienbienphu");
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private List<MarkerOptions> getMarkerOptionsList() {
        List<MarkerOptions> markers = new ArrayList<>();

        markers.add(new MarkerOptions().position(new LatLng(10.777268218978266, 106.69523772297113)).title("Dinh Độc Lập"));
        markers.add(new MarkerOptions().position(new LatLng(20.970983686945782, 106.76340775064018)).title("Bạch Đằng Giang"));
        markers.add(new MarkerOptions().position(new LatLng(21.453633480797382, 105.95821867879603)).title("Sông Như Nguyệt"));
        markers.add(new MarkerOptions().position(new LatLng(21.042772795975253, 105.84731782197028)).title("Đông Bộ Đầu"));
        markers.add(new MarkerOptions().position(new LatLng(21.607626503291158, 106.54238698085749)).title("Ải Chi Lăng"));
        markers.add(new MarkerOptions().position(new LatLng(10.325467322188175, 106.24804066529335)).title("Rạch Gầm - Xoài Mút"));
        markers.add(new MarkerOptions().position(new LatLng(21.012901756564215, 105.82427927777248)).title("Gò Đống Đa"));
        markers.add(new MarkerOptions().position(new LatLng(21.385273345879167, 103.01018260968766)).title("Điện Biên Phủ 1954"));

        return markers;
    }
}