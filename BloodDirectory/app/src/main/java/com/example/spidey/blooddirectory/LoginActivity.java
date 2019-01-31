package com.example.spidey.blooddirectory;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnSignup;
    String r;
    TextView mTextViewForget;
    EditText mEditText,mEditText2,mEditText3;
    SQLiteDatabaseOperation dbobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.button);
        mEditText = findViewById(R.id.editText);
        mEditText2 = findViewById(R.id.editText2);
        mEditText3 = findViewById(R.id.editText3);
        btnLogin.setEnabled(false);
        mEditText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals(""))
                {
                    btnLogin.setEnabled(false);
                }
                else
                    btnLogin.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dbobj = new SQLiteDatabaseOperation(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1,string2,stringUN,stringPASS;
                r=mEditText3.getText().toString();
                stringUN = mEditText.getText().toString();
                stringPASS = mEditText2.getText().toString();
                ArrayList list=dbobj.ReadDataLogin(r);
                if(list.size()>0)
                {
                    string1 = list.get(5).toString();
                    string2 = list.get(6).toString();
                    if (stringPASS.equals(string2) && stringUN.equals(string1))
                    {
                        Intent intent = new Intent(LoginActivity.this,LoginToMainActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginActivity.this,"Invalid Username and Password",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginActivity.this,"Such Database does not exist !!",Toast.LENGTH_LONG).show();
            }
        });

        btnSignup = findViewById(R.id.button2);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        mTextViewForget = findViewById(R.id.textView8);
        mTextViewForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewForget.setTextColor(Color.rgb(125, 60, 152));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final Intent intent = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                        LoginActivity.this.startActivity(intent);
                    }
                },300);
            }
        });

    }

    public String getvalue() {
        return r;
    }
}
