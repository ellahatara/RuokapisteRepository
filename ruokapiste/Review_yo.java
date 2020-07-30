package com.example.ruokapiste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.google.android.material.textfield.TextInputEditText;

/*Review activity, which is for creating a new review to the restaurant. Case: Ylioppilastalo*/

public class Review_yo extends Restaurant1Activity{

    private Button saveButton;
    private Button sendButton;
    private Button backButton;
    private TextInputEditText reviewText;
    private RatingBar ratingStars;
    float stars = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_yo);
        /* Method for clicking the buttons. */
        clickSend();
        clickSave();
        clickBackButton();

        ratingStars= findViewById(R.id.ratingBar);
        reviewText = findViewById(R.id.reviewText);
        /* Getting the number of stars, which the user gave in the review form. It returns
         * the stars as a float. */
        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                stars = (float) ratingBar.getRating();
                return;
            }
        });
    }
    private void clickBackButton () {
        backButton = findViewById(R.id.backReviewButton1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBack();
            }
        });
    }
    public void launchBack () {
        Intent intent = new Intent(Review_yo.this, Restaurant1Activity.class);
        startActivity(intent);
    }
    private void clickSave() {
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getReview();
                launchMainView();
            }
        });
    }
    private void clickSend() {
        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getReview();
                launchMainView();
            }
        });
    }
    private void launchMainView(){
        Intent intent = new Intent(Review_yo.this, Restaurant1Activity.class);
        startActivity(intent);
    }
    /* This method read the review text and the stars, which are entered by the user. There is a
     *  checking if the user input is null and in that case it gives the default text as a parameter.
     *  Method also gives the specific filename, calls a method and sends all those three parameters
     *  to writing method in the Write class.*/
    private void getReview() {
        String newReviewText = reviewText.getText().toString();
        float stars = ratingStars.getRating();
        if (newReviewText != null) {
            String filename = "review_yo.csv";
            Write.writeReview(newReviewText, stars, filename);
        } else {
            newReviewText = "No reviews available";
            String filename = "review_yo.csv";
            Write.writeReview(newReviewText, stars, filename);

        }
    }
}

