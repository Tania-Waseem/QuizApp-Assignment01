package com.example.assignment02_fooddeliveryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private ViewSwitcher viewSwitcher;
    private Button loginTabButton;
    private Button signUpTabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Ensure this matches your layout XML file

        // Initialize UI components
        viewSwitcher = findViewById(R.id.viewSwitcher);
        loginTabButton = findViewById(R.id.buttonLoginTab);
        signUpTabButton = findViewById(R.id.buttonSignUpTab);

        // Initially, set the Login tab active
        setActiveTab(loginTabButton, signUpTabButton);

        // Switch to Sign-Up tab
        signUpTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSwitcher.showNext(); // Show the next view
                setActiveTab(signUpTabButton, loginTabButton); // Update active tab
            }
        });

        // Switch to Login tab
        loginTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSwitcher.showPrevious(); // Show the previous view
                setActiveTab(loginTabButton, signUpTabButton); // Update active tab
            }
        });
    }

    // Method to highlight the active tab and reset the inactive one
    private void setActiveTab(Button activeTab, Button inactiveTab) {
        // Set colors for the active tab
        activeTab.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        activeTab.setTextColor(getResources().getColor(android.R.color.white));

        // Set colors for the inactive tab
        inactiveTab.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray));
        inactiveTab.setTextColor(getResources().getColor(android.R.color.black));
    }
}
