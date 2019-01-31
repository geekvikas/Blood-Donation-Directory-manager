package com.example.spidey.blooddirectory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcceptedReqFragment extends Fragment {


    public AcceptedReqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accepted_req, container, false);
        final ListView listView = view.findViewById(R.id.list);
        String[] values = new String[] {"No Request Accepted Yet !!"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

// ListView Clicked item index
                int itemPosition = position;
// ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

// Show Alert
                Toast.makeText(getActivity(),itemValue , Toast.LENGTH_LONG)
                        .show();

            }
        });





        return  view;
    }

}
