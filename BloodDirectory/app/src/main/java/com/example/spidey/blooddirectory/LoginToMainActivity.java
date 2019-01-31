package com.example.spidey.blooddirectory;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginToMainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_main);

        t = findViewById(R.id.textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t.setText("Logged in . . .");
                Toast toast = Toast.makeText(LoginToMainActivity.this,"Login Successful !!",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,0,80);
                toast.show();
                final Intent intent = new Intent(LoginToMainActivity.this,MainActivity.class);
                LoginToMainActivity.this.startActivity(intent);
                LoginToMainActivity.this.finish();
            }
        },2000);



    }
}
