package com.dealfaro.luca.backandforthstudio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    static final public String MYPREFS = "myprefs";
    static final public String PREF_STRING_2 = "string_1";
    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //To display first string in second activity
        SharedPreferences settings = getSharedPreferences(MainActivity.MYPREFS, 0);
        String enter1 = settings.getString(MainActivity.PREF_STRING_1, "");
        TextView tv_string1 = (TextView)findViewById(R.id.activity1Text);
        tv_string1.setText(enter1);

        EditText edv_string2 = (EditText) findViewById(R.id.editText);
        if(appInfo.sharedString!=null){
            edv_string2.setText(appInfo.sharedString);
        }
    }

    public void enterText2(View V){
        EditText edv2 = (EditText) findViewById(R.id.editText);
        String string2 = edv2.getText().toString();
        appInfo.setColor(string2);

    }

    public void goFirst(View V) {
        // Go to second activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
