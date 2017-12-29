package com.example.ioutd.implicitintentexample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.icu.util.Calendar;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Use annotations to bind the views in this activity with ButterKnife
        ButterKnife.bind(this);
    }


    // TODO (6): Implement the callClicked method
        // Create a uri containing the phone number to be called
        // Create the call intent to perform the dial action
        // Start the activity if the intent can be handled


    // TODO (7): Implement the mapClicked method
        // Create a uri containing the location to be displayed
        // Create the map intent to perform the view action
        // Start the activity if the map intent can be handled


    // TODO (8): Implement the webpageClicked method
        // Create a uri containing the webpage to be displayed
        // Create the web intent to perform the view action
        // Start the activity if the web intent can be handled


    // TODO (9): Implement the emailClicked method
        // Create 3 String variables: email, subject, and bodyText
        // Create the email intent to perform the send action
            // Set the type to "text/plain"
            // Use the putExtra method to pass in the email, subject, and bodyText
        // Display a chooser to select which app will handle the intent


    // TODO (10): Implement the emailClicked method
        // Set the start time to now
        // Set the end time an hour from now
        // Create the calendar intent with the insert action
        // Start the activity if the intent can be handled


    // TODO (4): Create a private method called startActivityIfVerified with an Intent as the parameter
        // Get the package manager
        // Query the package manager for activities that can handle the intent
        // If the returned list isn't empty, start the activity. Otherwise notify the user there's no apps
            //using a toast message


    // TODO (5 Create a method called showAppChooser with an Intent as the parameter
        // Create a title for the chooser
        // Create an intent for the chooser
        // Start the activity to display the chooser


}
