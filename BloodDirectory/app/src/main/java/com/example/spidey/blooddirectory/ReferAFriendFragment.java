package com.example.spidey.blooddirectory;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReferAFriendFragment extends Fragment {


    public ReferAFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_refer_afriend, container, false);
        Button btnW = view.findViewById(R.id.buttonWhatsapp);
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Hello I am Using My Blood Directory App, this is app to helping people who don't have Blood, to find people for exact blood group Match. To download the app please click on the link : https://drive.google.com/file/d/1nGLdVXRQTS5r1NRvYslknXcvLb1HSOJ_/view?usp=sharing";
                sendWhatsApp(msg);
                Toast.makeText(getActivity(), "Sharing via WhatsApp  !!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnF = view.findViewById(R.id.buttonFacebook);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFacebook();
                Toast.makeText(getActivity(), "Sharing via Facebook !!", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
    private void sendWhatsApp(String message)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,message);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }
    private void sendFacebook()
    {
        Intent sendIntent = new Intent();
        final String urlFB = "https://www.facebook.com";
        sendIntent.setAction(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(urlFB));
        startActivity(sendIntent);
    }

}
