package com.example.nudgerewriten;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    private EditText licencecode;
    public Shared shared;
    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length

        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 8) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                shared.writeLoginStatus(true);

            }
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        shared = new Shared(getApplicationContext());
        if (shared.readLoginStatus()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else
        {
            licencecode = (EditText) findViewById(R.id.licenceCode);
            licencecode.addTextChangedListener(mTextEditorWatcher);
        }
    }
}