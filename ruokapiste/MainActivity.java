package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/* MainActivity class with login button and a two textfields, where the user can enter their
* username and password. */

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        configureLoginButton();
    }
     private void configureLoginButton(){
        loginButton =  findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchMainView();
            }
        });
     }
    private void launchMainView(){
        Intent intent = new Intent(MainActivity.this, MainViewActivity.class);
        startActivity(intent);
    }

}


