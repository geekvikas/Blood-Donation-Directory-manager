package com.example.spidey.blooddirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button btn,btn2;
    TextView txt,txt2;
    EditText mEditText;

    SQLiteDatabaseOperation dbobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        mEditText = findViewById(R.id.editText);


        dbobj = new SQLiteDatabaseOperation(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r;
                r=mEditText.getText().toString();
                ArrayList list=dbobj.ReadData(r);
                if(list.size()>0)
                {
                    txt.setText("Your Username is : "+list.get(6).toString());
                    txt2.setText("Your Password is : "+list.get(7).toString());
                }
                else
                {
                    Toast.makeText(ForgetPasswordActivity.this,"Invalid rollno",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r;
                r=mEditText.getText().toString();
                int res=dbobj.DeleteRecord(r);
                if(res>0)
                {
                    Toast.makeText(ForgetPasswordActivity.this,"Record has been deleted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ForgetPasswordActivity.this,"Record not found ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
