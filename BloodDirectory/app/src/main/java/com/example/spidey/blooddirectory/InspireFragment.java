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
public class InspireFragment extends Fragment {


    public InspireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_inspire, container, false);
        final EditText mEditText;
        mEditText = view.findViewById(R.id.editText);

        Button btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEditText.setText("");

                        Toast toast = Toast.makeText(getActivity(), "Your Reponse is Saved !", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM,0,400);
                        toast.show();
                    }
                },700);
            }
        });

        return view;
    }

}
