package com.example.spidey.blooddirectory;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RaisedReqFragment extends Fragment {

    public RaisedReqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raised_req, container, false);
        String[] BloodGroup = {"*Select Blood Group*","O+","O-","A+","A-","B+","B-","AB+","AB-"};
        final Spinner mSpinner = view.findViewById(R.id.spinner);
        ArrayAdapter ad1 = new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,BloodGroup);
        mSpinner.setAdapter(ad1);

        final EditText mEditText,mEditText2,mEditText3,mEditText4;
        mEditText = view.findViewById(R.id.editText);
        mEditText2 = view.findViewById(R.id.editText2);
        mEditText3 = view.findViewById(R.id.editText3);
        mEditText4 = view.findViewById(R.id.editText4);

        final CheckBox mCheckBox = view.findViewById(R.id.checkBox);

        Button btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSpinner.setSelection(0);
                        mEditText.setText("");
                        mEditText2.setText("");
                        mEditText3.setText("");
                        mEditText4.setText("");
                        mCheckBox.setChecked(false);

                        Toast toast = Toast.makeText(getActivity(), "Your Request is Raised !", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM,0,250);
                        toast.show();
                    }
                },700);
            }
        });



        return  view;
    }

}
