package com.dealfaro.luca.backandforthstudio;

/**
 * Created by kcilia on 4/23/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity{
    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        //To show string from first activity


        //To show string form second activity

    }

    public void enterText(View V){
        EditText edv_string3 = (EditText) findViewById(R.id.editText);
        String string3 = edv_string3.getText().toString();


    }

    public void goSecond(View V){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goFirst(View V){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
