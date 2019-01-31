package com.example.spidey.blooddirectory;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        final SQLiteDatabaseOperation dbobj = new SQLiteDatabaseOperation(getActivity());
        final TextView txt1,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
        txt1 = view.findViewById(R.id.textViewUsername);
        txt3 = view.findViewById(R.id.textViewEmailAddress);
        txt4 = view.findViewById(R.id.textViewContact);
        txt5 = view.findViewById(R.id.textViewName1);
        txt6 = view.findViewById(R.id.textViewDOB);
        txt7 = view.findViewById(R.id.textViewGender);
        txt8 = view.findViewById(R.id.textViewBloodGroup);
        txt9 = view.findViewById(R.id.textViewAge);
        txt10 = view.findViewById(R.id.textViewCity);

        final EditText mEditText = view.findViewById(R.id.editTextSRNO);
        final Context context = getActivity();
        final String[] mString = new String[1];
        final String[] strUsername = new String[1];
        final String[] strEmail = new String[1];
        final String[] strContact = new String[1];
        final String[] strCity = new String[1];

        Button btn = view.findViewById(R.id.buttonSRNO);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r;
                r=mEditText.getText().toString();
                mString[0] = String.valueOf(Integer.parseInt(r));
                ArrayList list=dbobj.ReadDataProfile(r);
                if(list.size()>0)
                {
                    txt1.setText(list.get(6).toString());           //6
                    txt3.setText(list.get(10).toString());           //10
                    txt4.setText(list.get(9).toString());           //9
                    txt5.setText(list.get(1).toString());           //1
                    txt6.setText(list.get(2).toString());           //2
                    txt7.setText(list.get(3).toString());           //3
                    txt8.setText(list.get(4).toString());           //4
                    txt9.setText(list.get(5).toString());           //5
                    txt10.setText(list.get(11).toString());           //11
                    //Toast.makeText(getActivity(), "0= "+list.get(0).toString()+" 1= "+list.get(1).toString()+" 2= "+list.get(2).toString()+" 3= "+list.get(3).toString()+" 4= "+list.get(4).toString()+" 5= "+list.get(5).toString()+" 6= "+list.get(6).toString()+" 7= "+list.get(7).toString()+" 8= "+list.get(8).toString()+" 9= "+list.get(9).toString()+" 10= "+list.get(10).toString()+" 11= "+list.get(11).toString(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"Invalid rollno",Toast.LENGTH_LONG).show();
                }
            }
        });

        ImageButton img1,img2,img3,img4;
        img1 = view.findViewById(R.id.imageButtonUpdateUsername);
        img2 = view.findViewById(R.id.imageButtonUpdateEmail);
        img3 = view.findViewById(R.id.imageButtonUpdateContact);
        img4 = view.findViewById(R.id.imageButtonUpdateCity);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts,null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = promptsView.findViewById(R.id.editTextDialogUserInput);

                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt1.setText(userInput.getText());
                        strUsername[0] = txt1.getText().toString();
                        int res=dbobj.UpdateRecordUsername(mString[0], strUsername[0]);
                        if(res>0)
                        {
                            Toast.makeText(getActivity(), "Record updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Record not found", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts,null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = promptsView.findViewById(R.id.editTextDialogUserInput);

                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt3.setText(userInput.getText());
                        strEmail[0] = txt3.getText().toString();
                        int res=dbobj.UpdateRecordEmail(mString[0], strEmail[0]);
                        if(res>0)
                        {
                            Toast.makeText(getActivity(), "Record updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Record not found", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts,null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = promptsView.findViewById(R.id.editTextDialogUserInput);

                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt4.setText(userInput.getText());
                        strContact[0] = txt4.getText().toString();
                        int res=dbobj.UpdateRecordContact(mString[0], strContact[0]);
                        if(res>0)
                        {
                            Toast.makeText(getActivity(), "Record updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Record not found", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts,null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = promptsView.findViewById(R.id.editTextDialogUserInput);

                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt10.setText(userInput.getText());
                        strCity[0] = txt10.getText().toString();
                        int res=dbobj.UpdateRecordCity(mString[0], strCity[0]);
                        if(res>0)
                        {
                            Toast.makeText(getActivity(), "Record updated", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Record not found", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });



        return  view;
    }

}
