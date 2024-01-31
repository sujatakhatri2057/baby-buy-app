package com.example.babybuy.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.babybuy.Database.Database;
import com.example.babybuy.Model.AuthDatamodel;
import com.example.babybuy.R;

import java.util.ArrayList;


public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }


    TextView userfragFullname, userfragEmail,userfragFullnameforlogo;
    String Emailfromhomeactivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        Database db = new Database(getActivity());
        userfragFullname = view.findViewById(R.id.userfragfullname);
        userfragEmail = view.findViewById(R.id.userfragEmail);
        userfragFullnameforlogo = view.findViewById(R.id.tv_name);

        Bundle data = getArguments();

        if(data != null){
            Emailfromhomeactivity = data.getString("Email1");
            String fullname = db.getfullname(Emailfromhomeactivity);
            userfragEmail.setText(Emailfromhomeactivity);
            userfragFullname.setText(fullname);
            userfragFullnameforlogo.setText(fullname);

        }




        return view;
    }
}