package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* This class is for making sure if the user wants to use points for free meal. */

public class UseConfirmation extends PointsActivity {
    private Button yesButton;
    private Button noButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_points);
        /* Methods for clicking yes and no buttons */
        clickYesButton();
        clickNoButton();

    }
    /* If the user is sure for using 10 points, this clicking method also calls the minusPoints
    *  method in points class and the amount of points is reduced by 10. */
    private void clickYesButton () {
        yesButton = findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PointsActivity.minusPoints();
                launchYes();
            }
        });
    }
    public void launchYes () {
        Intent intent = new Intent(UseConfirmation.this, PointsActivity.class);
        startActivity(intent);
    }
    private void clickNoButton () {
        noButton = findViewById(R.id.noButton);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNo();
            }
        });
    }
    public void launchNo () {
        Intent intent = new Intent(UseConfirmation.this, PointsActivity.class);
        startActivity(intent);
    }
}