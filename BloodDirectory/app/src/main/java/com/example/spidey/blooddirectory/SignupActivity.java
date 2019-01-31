package com.example.spidey.blooddirectory;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    SQLiteDatabaseOperation dboj;

    Spinner mSpinner,mSpinner2,mSpinner3,mSpinner4,mSpinner5;
    Button mButtonRegister,mButtonReset;
    EditText e0,e,e2,e3,e4,e5,e6,e7;
    public AlertDialog.Builder mBuilder;

    String[] gender = {"*Select Gender*","Male","Female"};
    String[] BloodGroup = {"*Select Blood Group*","O+","O-","A+","A-","B+","B-","AB+","AB-"};
    String[] age = {"*Select Age*","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    String[] month = {"*Select Month*","2-Months","3-Months","4-Months","5-Months","6-Months"};
    String[] choose = {"*Choose Yes/No*","Yes","No"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dboj = new SQLiteDatabaseOperation(this);

        mBuilder = new AlertDialog.Builder(this).setMessage("Are you sure to reset the SignUp page?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        e0.setText("");
                        e.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        e6.setText("");
                        e7.setText("");

                        mSpinner.setSelection(0);
                        mSpinner2.setSelection(0);
                        mSpinner3.setSelection(0);
                        mSpinner4.setSelection(0);
                        mSpinner5.setSelection(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setTitle("Prompt Message");

        e0 = findViewById(R.id.editText0);
        e = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        e5 = findViewById(R.id.editText5);
        e6 = findViewById(R.id.editText6);
        e7 = findViewById(R.id.editText7);


        mSpinner = findViewById(R.id.spinner);
        ArrayAdapter ad = new ArrayAdapter(SignupActivity.this,android.R.layout.simple_dropdown_item_1line,gender);
        mSpinner.setAdapter(ad);
        mSpinner2 = findViewById(R.id.spinner2);
        ArrayAdapter ad1 = new ArrayAdapter(SignupActivity.this,android.R.layout.simple_dropdown_item_1line,BloodGroup);
        mSpinner2.setAdapter(ad1);
        mSpinner3 = findViewById(R.id.spinner3);
        ArrayAdapter ad2 = new ArrayAdapter(SignupActivity.this,android.R.layout.simple_dropdown_item_1line,age);
        mSpinner3.setAdapter(ad2);
        mSpinner4 = findViewById(R.id.spinner4);
        ArrayAdapter ad3 = new ArrayAdapter(SignupActivity.this,android.R.layout.simple_dropdown_item_1line,month);
        mSpinner4.setAdapter(ad3);
        mSpinner5 = findViewById(R.id.spinner5);
        ArrayAdapter ad4 = new ArrayAdapter(SignupActivity.this,android.R.layout.simple_dropdown_item_1line,choose);
        mSpinner5.setAdapter(ad4);

        mButtonRegister = findViewById(R.id.button);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r, n,dob,g, bg,a,un,pass,msod, mn, email, city, itdb;
                r=e0.getText().toString();
                n=e.getText().toString();
                dob=e2.getText().toString();
                g=mSpinner.getSelectedItem().toString();
                bg=mSpinner2.getSelectedItem().toString();
                a=mSpinner3.getSelectedItem().toString();
                un=e3.getText().toString();
                pass=e4.getText().toString();
                msod=mSpinner4.getSelectedItem().toString();
                mn=e5.getText().toString();
                email=e6.getText().toString();
                city=e7.getText().toString();
                itdb=mSpinner5.getSelectedItem().toString();

                long res = dboj.AddRecord(r, n,dob,g, bg,a,un,pass,msod, mn, email, city, itdb);
                if(res>0)
                {
                    Toast.makeText(SignupActivity.this, "Record inserted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this,SignupToLoginLoadActivity.class);
                    startActivity(intent);
                }


            }
        });
        mButtonReset = findViewById(R.id.button2);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
            android.support.v7.app.AlertDialog.Builder build;
            build = new android.support.v7.app.AlertDialog.Builder(this).setMessage("Are you sure you want to exit : ")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).setTitle("Confirm exit?");
            build.show();
    }
}
