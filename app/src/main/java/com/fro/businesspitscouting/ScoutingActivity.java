package com.fro.businesspitscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
    //edit text
    EditText q1;
    EditText q2;
    EditText q3;
    EditText q4;
    EditText q5;
    EditText q6;
    EditText q7;
    EditText q8;
    EditText q9;
    EditText q10;

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
        //edit text
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);
        q10 = findViewById(R.id.q10);

        //Saving values when switching pages
        //type boxes
        q1.setText(Values.q1);
        q2.setText(Values.q2);
        q3.setText(Values.q3);
        q4.setText(Values.q4);
        q5.setText(Values.q5);
        q6.setText(Values.q6);
        q7.setText(Values.q7);
        q8.setText(Values.q8);
        q9.setText(Values.q9);
        q10.setText(Values.q10);

        //adding text return values
        q1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q1 = q1.getText().toString();}
        });
        q2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q2 = q2.getText().toString();}
        });
        q3.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q3 = q3.getText().toString();}
        });
        q4.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q4 = q4.getText().toString();}
        });
        q5.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q5 = q5.getText().toString();}
        });
        q6.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q6 = q6.getText().toString();}
        });
        q7.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q7 = q7.getText().toString();}
        });
        q8.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q8 = q8.getText().toString();}
        });
        q9.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q9 = q9.getText().toString();}
        });
        q10.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.q10 = q10.getText().toString();}
        });

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