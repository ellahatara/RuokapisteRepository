package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*Profile activity is to show the user's information. Activity has buttons for navigating back to
* mainview and editing the profile. */

public class ProfileActivity extends AppCompatActivity {

    private Button editProfileButton;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /* Methods for clicking the buttons and a display to show the user's information, which
        * include name, email, address and a password. */
        clickEditProfileButton();
        clickBackButton();
        TextView profileDisplay = (TextView)findViewById(R.id.profileDisplay);
        String[] data = Read.readFile();
        profileDisplay.setText("Name: " + data[0] + "\nEmail: "+ data[1] + "\nAddress: "+ data[2] + "\nPassword: "+ data[3]);
    }

    private void clickEditProfileButton () {
        editProfileButton = findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchEditProfile();
            }
        });
    }
    public void launchEditProfile () {
        Intent intent = new Intent(ProfileActivity.this, EditProfile.class);
        startActivity(intent);
    }
    private void clickBackButton () {
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack () {
        Intent intent = new Intent(ProfileActivity.this, MainViewActivity.class);
        startActivity(intent);
    }

}

