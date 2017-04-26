package com.dealfaro.luca.backandforthstudio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final public String MYPREFS = "myprefs";
    static final public String PREF_STRING_1 = "string_1";
    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //To enter in string for first activity
        SharedPreferences settings = getSharedPreferences(MainActivity.MYPREFS, 0);
        String string1 = settings.getString(MainActivity.PREF_STRING_1, "");
        EditText edv_string1 = (EditText) findViewById(R.id.editText);
        edv_string1.setText(string1);

        // To display string from second activity in first activity
        TextView tv_string2 = (TextView)findViewById(R.id.activity2Text);
        tv_string2.setText(appInfo.sharedString);

        //To display string from third activity in first activity
        SharedPreferences settings3 = getSharedPreferences(ThirdActivity.PREFS3,0);
        String string3 = settings3.getString(ThirdActivity.PREF_STRING_3, "");
        TextView tv_string3 = (TextView)findViewById(R.id.activity3Text);
        tv_string3.setText(string3);
    }

    public void enterText(View v){
        EditText edv = (EditText) findViewById(R.id.editText);
        String text1 = edv.getText().toString();
        SharedPreferences settings = getSharedPreferences(MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREF_STRING_1, text1);
        editor.commit();
    }

    public void goSecond(View V) {
        // Go to second activity
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goThird(View V){
        //Go to third activity
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
