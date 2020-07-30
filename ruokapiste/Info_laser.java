package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* Activity class for the restaurant information. Case: Laseri */

public class Info_laser extends Restaurant3Activity {
    private Button backInfoButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_laser);
        clickBackButton();

    }
    private void clickBackButton(){
        backInfoButton3 = findViewById(R.id.backInfoButton3);
        backInfoButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack(){
        Intent intent = new Intent(Info_laser.this, Restaurant3Activity.class);
        startActivity(intent);
    }


}