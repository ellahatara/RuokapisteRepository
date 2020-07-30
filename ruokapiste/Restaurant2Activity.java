package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/*Restaurant activity shows a review and has buttons for navigating back, viewing info
 * and creating a new review. Case: Lut Buffet*/

public class Restaurant2Activity extends AppCompatActivity {
    private FloatingActionButton reviewButton2;
    private ImageButton infoButton;
    private CheckBox cb;
    private Button backButton;
    private static int votes = 0;
    String filename = "review_lut.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant2);
        TextView reviewDisplay2 = findViewById(R.id.reviewDisplay2);
        TextView textVotes = findViewById(R.id.textVotes);
        /* Button methods */
        clickBackButton();
        configureReviewButton1();
        clickInfoButton();
        checkboxClicked();
        /* Calling a reading method from read class and setting a text to text view s the
         * user sees the review. Votes text is to show how many votes the review has got. */
        String[] reviewText = Read.readReview(filename);
        reviewDisplay2.setText("Stars: " + reviewText[0] + "\nReview: " + reviewText[1]);
        textVotes.setText("Votes: " + votes);
    }
    /* Method for checking if the checkbox is clicked. When it is clicked, the amount of votes
     *  increases by 1. */
    public void checkboxClicked() {
        CheckBox cb = findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    votes = votes + 1;
                } else {

                }
            }
        });
    }

    private void configureReviewButton1(){
        reviewButton2 = findViewById(R.id.reviewButton2);
        reviewButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchReview();
            }
        });
    }
    private void launchReview(){
        Intent intent = new Intent(Restaurant2Activity.this, Review_lut.class);
        startActivity(intent);
    }
    private void clickInfoButton(){
        infoButton = findViewById(R.id.infoButton2);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchInfo();
            }
        });
    }
    private void launchInfo(){
        Intent intent = new Intent(Restaurant2Activity.this, Info_lut.class);
        startActivity(intent);
    }
    private void clickBackButton () {
        backButton = findViewById(R.id.backButton1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack () {
        Intent intent = new Intent(Restaurant2Activity.this, MainViewActivity.class);
        startActivity(intent);
    }
}