package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* Activity class for the restaurant information. Case: Lut Buffet */

public class Info_lut extends Restaurant2Activity {
    private Button backInfoButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_lut);
        clickBackButton();

    }
    private void clickBackButton(){
        backInfoButton2 = findViewById(R.id.backInfoButton2);
        backInfoButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack(){
        Intent intent = new Intent(Info_lut.this, Restaurant2Activity.class);
        startActivity(intent);
    }


}