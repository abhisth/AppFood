package com.example.myfoodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistersuccessFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registersuccess, container, false);
        EditText editText  = view.findViewById(R.id.editEmailSignIN);
        EditText editText1 = view.findViewById(R.id.editPassSignIn);

        DBHelper DB = new DBHelper(getActivity());

        Button Login = view.findViewById(R.id.LogIn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText.getText().toString();
                String pass = editText1.getText().toString();

                if(user.equals("") && pass.equals(""))
                    Toast.makeText(getActivity(),"Please fill the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if (checkuserpass == true){
                        Toast.makeText(getActivity(),"Log in succesful",Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(requireView()).navigate(R.id.action_registersuccessFragment_to_homePageActivity);
                    }
                    else {
                        Toast.makeText(getActivity(),"Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}