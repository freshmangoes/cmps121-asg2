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

    static final public String PREFS3 = "prefs3";
    static final public String PREF_STRING_3 = "string_3";
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
        SharedPreferences settings = getSharedPreferences(MainActivity.MYPREFS, 0);
        String string1 = settings.getString(MainActivity.PREF_STRING_1, "");
        TextView tv_string1 = (TextView)findViewById(R.id.activity1Text);
        tv_string1.setText(string1);


        //To show string from second activity
        TextView tv_string2 = (TextView) findViewById(R.id.activity2Text);
        tv_string2.setText(appInfo.sharedString);


        //To display string from third activity
        SharedPreferences settings3 = getSharedPreferences(PREFS3, 0);
        String string3 = settings3.getString(PREF_STRING_3, "");
        EditText edv_string3 = (EditText)findViewById(R.id.editText);
        edv_string3.setText(string3);
    }

    public void enterText(View V){
        EditText edv_string3 = (EditText) findViewById(R.id.editText);
        String string3 = edv_string3.getText().toString();
        SharedPreferences settings3 = getSharedPreferences(PREFS3, 0);
        SharedPreferences.Editor editor3 = settings3.edit();
        editor3.putString(PREF_STRING_3, string3);
        editor3.commit();


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
