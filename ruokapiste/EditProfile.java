package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

/* Class for editing the users profile. There are four main attributes in this class and a button
for saving the profile with its new information.*/


public class EditProfile extends ProfileActivity {
    private TextInputEditText nameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText addressEditText;
    private Button saveProfileButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        addressEditText = findViewById(R.id.addressEditText);
        
        clickSave();
    }
    /* If the user clicks save button, this method also calls the getData() method to write the
    *  entered information to a file. */
    public void clickSave() {
        saveProfileButton = findViewById(R.id.saveProfileButton);
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                launchSaveProfile();
            }
        });
    }
    public void launchSaveProfile() {
            Intent intent = new Intent(EditProfile.this, ProfileActivity.class);
            startActivity(intent);
    }

    /*A method, which is called from the "clickSave" method. This method takes the user inputs
    * and sends them to the Write class as parameters. */
    private void getData(){
        String newNameText = nameEditText.getText().toString();
        String newEmailText = emailEditText.getText().toString();
        String newPasswordText = passwordEditText.getText().toString();
        String newAddressText = addressEditText.getText().toString();
        Write.writeToFile(newNameText, newEmailText, newPasswordText, newAddressText);

    }
}
