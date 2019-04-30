package com.example.nudgerewriten;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private EditText licencecode;
    private Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences msharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        if (msharedPreferences.contains(SHARED_PREFS))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            setContentView(R.layout.activity_login);
            licencecode = (EditText) findViewById(R.id.licenceCode);
            savebtn = (Button) findViewById(R.id.submitButton);
            savebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    savedata();
                }
                public void savedata() //To save Data in SharePreferences
                {
                    SharedPreferences.Editor editor = msharedPreferences.edit();
                    editor.putString(TEXT, licencecode.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });


        }
    }
}