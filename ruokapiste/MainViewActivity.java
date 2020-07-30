package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/* Class for the mainview activity of the app. This mainview includes the restaurants
* and their menus and a buttons to profile, points and settings. */

public class MainViewActivity extends AppCompatActivity {

    private Button profileButton;
    private Button settingsButton;
    private Button pointsButton;
    private Button restaurant1Button;
    private Button restaurant2Button;
    private Button restaurant3Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainview);

        /* All the methods for clicking buttons as a one list. There are separate launching
        *  methods for the buttons. */
        configureProfileButton();
        configureSettingsButton();
        configurePointsButton();
        configureRestaurant1Button();
        configureRestaurant2Button();
        configureRestaurant3Button();

    }
    private void configureProfileButton(){
        profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchProfile();
            }
        });
    }
        private void configureSettingsButton(){
        settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchSettings();
            }
        });
    }
    private void configurePointsButton(){
        pointsButton = findViewById(R.id.pointsButton);
        pointsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchPoints();
            }
        });
    }
    private void configureRestaurant1Button() {
        restaurant1Button = findViewById(R.id.restaurant1Button);
        restaurant1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRestaurant1();
            }
        });
    }
    private void configureRestaurant2Button() {
        restaurant2Button = findViewById(R.id.restaurant2Button);
        restaurant2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRestaurant2();
            }
        });
    }
    private void configureRestaurant3Button() {
        restaurant3Button = findViewById(R.id.restaurant3Button);
        restaurant3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRestaurant3();
            }
        });
    }
    public void launchProfile() {
        Intent intent = new Intent(MainViewActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void launchSettings() {
        Intent intent = new Intent(MainViewActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void launchPoints() {
        Intent intent = new Intent(MainViewActivity.this, PointsActivity.class);
        startActivity(intent);
    }
    private void launchRestaurant1() {
        Intent intent = new Intent(MainViewActivity.this, Restaurant1Activity.class);
        startActivity(intent);
    }

    private void launchRestaurant2() {
        Intent intent = new Intent(MainViewActivity.this, Restaurant2Activity.class);
        startActivity(intent);
    }
    private void launchRestaurant3() {
        Intent intent = new Intent(MainViewActivity.this, Restaurant3Activity.class);
        startActivity(intent);
    }
}
