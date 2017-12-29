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

    /**
     * Calls a phone number
     * @param view
     */
    @OnClick(R.id.button_call)
    public void callClicked(View view){
        // Try changing this value
        String numberString = "555-555-5555";
        // The phone number to be called
        Uri numberUri = Uri.parse("tel:" + numberString);
        // Create the call intent to perform the dial action
        Intent callIntent = new Intent(Intent.ACTION_DIAL, numberUri);
        // Start the activity if the intent can be handled
        startActivityIfVerified(callIntent);
    }

    /**
     * Displays a location on the map
     * @param view
     */
    @OnClick(R.id.button_map)
    public void mapClicked(View view){
        // Try changing this value
        String locationString = "Mount Mihara, Japan";
        // Properly formats the string ex: 'Mount+Mihara,+Japan'
        locationString = locationString.replace(' ', '+');
        // The location to be displayed
        Uri locationUri = Uri.parse("geo:0,0?q=" + locationString);
        // Create the map intent to perform the view action
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
        // Start the activity if the intent can be handled
        startActivityIfVerified(mapIntent);
    }

    /**
     * Displays a webpage
     * @param view
     */
    @OnClick(R.id.button_webpage)
    public void webpageClicked(View view){
        // The webpage to be displayed
        Uri webpageUri = Uri.parse("http://www.tesla.com/models");
        // Create the web intent to perform the view action
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpageUri);
        // Start the activity if the intent can be handled
        startActivityIfVerified(webIntent);
    }

    /**
     * Sends an email
     * @param view
     */
    @OnClick(R.id.button_email)
    public void emailClicked(View view){
        // Try changing these three variables
        String email = "google@example.com";
        String subject = "Test Subject";
        String bodyText = "Test body text";

        // Create email Intent
        Intent emailIntent = new Intent(Intent.ACTION_SEND)
                // Set the type of data being sent
                .setType("text/plain")
                // Add the destination email as an extra
                .putExtra(Intent.EXTRA_EMAIL, new String[] {email})
                // Add the subject is an extra
                .putExtra(Intent.EXTRA_SUBJECT, subject)
                // Add the body text as an extra
                .putExtra(Intent.EXTRA_TEXT, bodyText);

        // Display apps that can send emails
        showAppChooser(emailIntent);
    }

    /**
     * Creates a calendar event
     * @param view
     */
    @OnClick(R.id.button_calendar)
    public void calendarClicked(View view){
        // Set the start time to now
        Calendar calendar = Calendar.getInstance(Locale.US);
        long beginTime = calendar.getTimeInMillis();
        // Set the end time an hour from now
        // Try changing this variable
        // Ex: calendar.add(Calendar.MINUTE, 15);
        calendar.add(Calendar.HOUR, 1);
        long endTime = calendar.getTimeInMillis();

        // Create the calendar intent with the insert action
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                .putExtra(CalendarContract.Events.TITLE, "Sky Diving")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "The Moon");

        // Start the activity if the intent can be handled
        startActivityIfVerified(calendarIntent);
    }

    /**
     * Starts the activity if there is an app installed that can handle it. Otherwise, notified the
     * user that it can't.
     * @param intent the intent to verify
     */
    private void startActivityIfVerified(Intent intent){
        // Get the package manager
        PackageManager packageManager = getPackageManager();
        // Retrieve all of the activities that can handle this intent
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);

        if (activities.size() > 0) {
            // Start the activity of the intent with action to be performed
            startActivity(intent);
        } else {
            // Notify the user there is no app to receive this intent
            Toast.makeText(this, R.string.cant_receive_intent, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Displays a chooser for selecting an app to handle an intent
     * @param intent the intent to be handled
     */
    private void showAppChooser(Intent intent) {
        // Create a title for the chooser
        String title = getResources().getString(R.string.chooser_title);
        // Create an intent for the chooser
        Intent chooserIntent = Intent.createChooser(intent, title);
        // Start the activity to display the chooser
        startActivityIfVerified(chooserIntent);
    }

}
