package com.fro.businesspitscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoutingActivity extends AppCompatActivity {
    //declaring
    // init buttons
    TextView submitButton;
    ImageButton yesButton;
    ImageButton noButton;
    //init frame
    View frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);
        //instantiating
        // init buttons
        submitButton = findViewById(R.id.submitButton);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        //init frame
        frame = findViewById(R.id.confirmFrame);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame.setVisibility(View.VISIBLE);

                //If yes button is clicked, sets the buttons invisible, and outputs the data into a JSON
                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        frame.setVisibility(View.GONE);
                        //Calls submitJSON class and submits all data
                        SubmitJSON submitJSON = new SubmitJSON();

                        submitJSON.submitData();
                        submitJSON.showToast(ScoutingActivity.this);

                        //Calls ResetValues class and clears all data
                        ResetValues resetValues = new ResetValues();
                        resetValues.clearData();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
                //If the no button is clicked it hides the buttons
                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        frame.setVisibility(View.GONE);
                    }
                });
            }
        });

    }
}