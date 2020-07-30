package com.example.ruokapiste;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;

/* Write class is to write user inputs to files. This class is called from review activities and the
*  profile editing class. */

public class Write {
    // Getting context.
    static Context context = App.getAppContext();

    /* This method writes the users profile information to a file. It takes the new name, email,
    *  address and password from the calling method and writes them to a .csv file. */
    public static void writeToFile(String newNameText, String newEmailText, String newPasswordText, String newAddressText) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput("profile.csv", Context.MODE_PRIVATE));

            osw.write("Name;Email;Address;Password");
            osw.write("\n");
            osw.write(newNameText + ";" + newEmailText + ";" + newAddressText + ";" + newPasswordText);
            osw.write("\n");
            osw.close();

        }
        catch (IOException e) {
            Log.e("Exception", "saving profile failed: " + e.toString());
        }
    }

    /* Review writing method is called from review activities. It takes the output filename,
    *  review stars and review text. They re written to the .csv file. */
    public static void writeReview(String reviewText, float stars, String filename) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            osw.write(stars + ";" + reviewText);
            osw.close();

        }
        catch (IOException e) {
            Log.e("Exception", "review failed: " + e.toString());
        }
    }
}
