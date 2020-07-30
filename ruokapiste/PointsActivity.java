package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/* Points activity shows the user's points, which can be spend for claiming a free meal. */

public class PointsActivity extends AppCompatActivity {
    private Button buttonPoints;
    private Button backButton2;
    private TextView pointsText;
    private static int points = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        TextView pointsText = (TextView)findViewById(R.id.pointsText);
        clickPointsButton();
        clickBackButton();
        /* This text is showing in the screen. */
        pointsText.setText("Your current points: " + points);
    }

    /* A method for decreasing the points by 10. */
    protected static void minusPoints() {
        points = points - 10;
    }
    private void clickPointsButton () {
        buttonPoints = findViewById(R.id.buttonPoints);
        buttonPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPoints();
            }
        });
    }
    public void launchPoints() {
        Intent intent = new Intent(PointsActivity.this, UseConfirmation.class);
        startActivity(intent);
    }
    private void clickBackButton () {
        backButton2 = findViewById(R.id.backButton2);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack () {
        Intent intent = new Intent(PointsActivity.this, MainViewActivity.class);
        startActivity(intent);
    }

}

