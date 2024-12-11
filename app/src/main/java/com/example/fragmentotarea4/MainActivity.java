package com.example.fragmentotarea4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Fragment())
                    .commit();
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_red) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new RedFragment())
                        .commit();
            } else if (item.getItemId() == R.id.nav_green) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new GreenFragment())
                        .commit();
            } else if (item.getItemId() == R.id.nav_blue) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new BlueFragment())
                        .commit();
            }
            return true;
        });
    }
}