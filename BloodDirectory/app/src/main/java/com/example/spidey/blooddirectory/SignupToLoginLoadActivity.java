package com.example.spidey.blooddirectory;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class SignupToLoginLoadActivity extends AppCompatActivity {

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_to_login_load);

        t = findViewById(R.id.textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t.setText("Redirecting . . .");
                Toast toast = Toast.makeText(SignupToLoginLoadActivity.this,"You are Registered",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,0,80);
                toast.show();
                final Intent intent = new Intent(SignupToLoginLoadActivity.this,LoginActivity.class);
                SignupToLoginLoadActivity.this.startActivity(intent);
                SignupToLoginLoadActivity.this.finish();
            }
        },2000);

    }
}
