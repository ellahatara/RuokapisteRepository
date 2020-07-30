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
* and creating a new review. Case: Ylioppilastalo*/

public class Restaurant1Activity extends AppCompatActivity {
    private FloatingActionButton reviewButton1;
    private ImageButton infoButton;
    private Button backButton;
    private CheckBox cb;
    private static int votes = 0;
    String filename = "review_yo.csv";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant1);
        TextView reviewDisplay1 = findViewById(R.id.reviewDisplay1);
        TextView textVotes = findViewById(R.id.textVotes);
        /* Button methods */
        clickBackButton();
        configureReviewButton1();
        clickInfoButton();
        checkboxClicked();
        /* Calling a reading method from read class and setting a text to text view s the
        * user sees the review. Votes text is to show how many votes the review has got. */
        String[] reviewText = Read.readReview(filename);
        reviewDisplay1.setText("Stars: " + reviewText[0] + "\nReview: " + reviewText[1]);
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
        reviewButton1 = findViewById(R.id.reviewButton1);
        reviewButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchReview();
                }
            });
    }
    private void launchReview(){
        Intent intent = new Intent(Restaurant1Activity.this, Review_yo.class);
        startActivity(intent);
    }
    private void clickInfoButton(){
        infoButton = findViewById(R.id.infoButton1);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchInfo();
            }
        });
    }
    private void launchInfo(){
        Intent intent = new Intent(Restaurant1Activity.this, Info_yo.class);
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
        Intent intent = new Intent(Restaurant1Activity.this, MainViewActivity.class);
        startActivity(intent);
    }
}


