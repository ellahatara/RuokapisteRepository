package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* Activity class for the restaurant information. Case: Ylioppilastalo */

public class Info_yo extends Restaurant1Activity {
    private Button backInfoButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_yo);
        clickBackButton();

    }
    private void clickBackButton(){
        backInfoButton1 = findViewById(R.id.backInfoButton1);
        backInfoButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack(){
        Intent intent = new Intent(Info_yo.this, Restaurant1Activity.class);
        startActivity(intent);
    }


}