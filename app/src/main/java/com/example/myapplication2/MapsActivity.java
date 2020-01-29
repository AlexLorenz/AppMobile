package com.example.myapplication2;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
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

    //Declarando variaveis para permissao
    private static final String[] LOCATION_PERMS={Manifest.permission.ACCESS_FINE_LOCATION};
    private static final int INITIAL_REQUEST = 1337;
    private static final int LOCATION_REQUEST=INITIAL_REQUEST + 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

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

        // Criando variaveis para localizacao
        LatLng sydney = new LatLng(-29.7549941, -51.150283);
        LatLng esteio = new LatLng(-29.8524632,-51.1845758);

        // Add marcadores
        mMap.addMarker(new MarkerOptions()
                .position(sydney)                          // Define a posicao do marcador
                .title("Marker in Sydney"));               // Define o título do marcador
        mMap.addMarker(new MarkerOptions()
                .position(esteio)
                .title("Esteio"));

//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(esteio).title("Esteio"));

        // Ao iniciar move a camera para o local escolhido
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12.0f));

        // Ativa o botão de zoom na tela
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Verifica a permissao para acessar a localizacao atual do dispositivo
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

        //Se não possuir, solicite
        else {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }
        }

        //Adiciona o botão de de localização atual
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        //
        mMap.getUiSettings().setCompassEnabled(true);

        // Adiciona rota
        mMap.addPolyline(new PolylineOptions()
                .add(sydney, esteio)
                .width(10)
                .color(Color.BLUE));
    }
}