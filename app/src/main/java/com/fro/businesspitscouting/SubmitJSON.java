package com.fro.businesspitscouting;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class SubmitJSON {

    Calendar calendar = Calendar.getInstance();

    String pathToExternalStorage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
    File path = new File(pathToExternalStorage + "/" + "Business-Sc-2024");
    //File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    public void submitData(){
        JSONObject jsonObject = new JSONObject();

        //output data
        try {jsonObject.put("SCOUTER_NAME", Values.sc_name);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TEAM_NUMBER", Values.teamNum);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 1", Values.q1);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 2", Values.q2);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 3", Values.q3);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 4", Values.q4);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 5", Values.q5);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 6", Values.q6);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 7", Values.q7);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 8", Values.q8);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 9", Values.q9);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("QUESTION 10", Values.q10);} catch (JSONException e) {throw new RuntimeException(e);}
        try {toJSON(jsonObject);} catch (IOException e) {e.printStackTrace();}
    }

    public void toJSON(JSONObject content) throws IOException {
        // Class to put the data into a JSON object
        FileOutputStream writer = new FileOutputStream(new File(path, "BUSINESS_SCOUTING_DATA_" + calendar.getTimeInMillis() + ".json"));
        writer.write(content.toString().getBytes());
        writer.close();
    }

    public void showToast(Context mContext){
        Toast.makeText(mContext, path.toString(), Toast.LENGTH_SHORT).show();
    }

}
