package com.example.ruokapiste;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Read class is for reading different files. Class is called from profile activity and restaurant
* activities. */

public class Read {
    static Context context = App.getAppContext();

    /* readFile method is for reading the user data. It returns the data and it is sent to the
    * profile activity, which calls this method and takes the returning data. */
    public static String[] readFile() {
        String profileInfo = "";
        String[] data = new String[0];
        try {
            InputStream is = context.openFileInput("profile.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((profileInfo = br.readLine()) != null) {
                data = profileInfo.split(";");
                System.out.println(profileInfo);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    /* readReview methods reads the review files. It takes the filename as a parameter and uses
    * it to read the right file. This method is called from restaurant activities. */
    public static String[] readReview(String filename) {
        String rivi = "";
        String[] reviewText = new String[2];
        try{
            InputStream is = context.openFileInput(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((rivi = br.readLine()) != null) {
                reviewText = rivi.split(";");
                System.out.println(reviewText);
            }
            is.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return reviewText;
    }
}