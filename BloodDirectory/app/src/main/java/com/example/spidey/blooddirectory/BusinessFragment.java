package com.example.spidey.blooddirectory;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessFragment extends Fragment {


    public BusinessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_business, container, false);
        final EditText mEditText,mEditText2,mEditText3,mEditText4,mEditText5;
        mEditText = view.findViewById(R.id.editText);
        mEditText2 = view.findViewById(R.id.editText2);
        mEditText3 = view.findViewById(R.id.editText3);
        mEditText4 = view.findViewById(R.id.editText4);

        Button btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEditText.setText("");
                        mEditText2.setText("");
                        mEditText3.setText("");
                        mEditText4.setText("");

                        Toast toast = Toast.makeText(getActivity(), "Your Reponse is Saved !", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM,0,400);
                        toast.show();
                    }
                },700);
            }
        });



        return view;    }

}
