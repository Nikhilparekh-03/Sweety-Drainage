package com.example.drainage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Savli extends FragmentActivity implements OnMapReadyCallback {
    private static final float zoom = 15f;
    FloatingActionButton floatingActionButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savli);
        floatingActionButton1 = findViewById(R.id.fsavali);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(this);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(floatingActionButton1);

            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.float_town, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Chhani:
                Toast.makeText(this, "Chhani", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Savli.this,chhani.class));

                break;
            case R.id.Savli:
                Toast.makeText(this, "Savli", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Savli.this, Savli.class));
                break;
        }

        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng savlii = new LatLng(22.561940, 73.222337);
        googleMap.addMarker(new MarkerOptions().title("Savli").position(savlii));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(savlii,zoom));


    }
}
