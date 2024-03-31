package com.fro.businesspitscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring
    //buttons
    TextView startButton;
    //edit text
    EditText scouterName;
    //dropdowns
    AutoCompleteTextView teamType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiating
        //button
        startButton = findViewById(R.id.startButton);
        //edit texts
        scouterName = findViewById(R.id.nameType);
        //dropdowns
        teamType = findViewById(R.id.teamType);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);
        //adds options to the team type box
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, teamNums);
        teamType.setThreshold(1);
        teamType.setAdapter(adapter);

        //Saving values when switching pages
        //type dropdown
        teamType.setText(String.valueOf(Values.teamNum));
        //type boxes
        scouterName.setText(Values.sc_name);

        //dropdown type return values
        teamType.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                String text = teamType.getText().toString();
                if (!text.equals("")){
                    Values.teamNum = Integer.parseInt(teamType.getText().toString());
                }}
        });


        //adding scouter name return values
        scouterName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.sc_name = scouterName.getText().toString();}
        });

        // changes to next page on click
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScoutingActivity.class));
            }
        });
    }
}