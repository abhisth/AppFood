package com.example.myfoodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginFragment extends Fragment {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_login, container, false);
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
                    Navigation.findNavController(requireView()).navigate(R.id.action_authActivity_to_homePageActivity);
                    }
                    else {
                        Toast.makeText(getActivity(),"Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        EditText editText  = view.findViewById(R.id.editEmailSignIN);
//        EditText editText1 = view.findViewById(R.id.editPassSignIn);
//
//        DBHelper DB = new DBHelper(getActivity());
//
//        Button Login = view.findViewById(R.id.LogIn);
//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//        String user = editText.getText().toString();
//                String pass = editText.getText().toString();
//
//                if(user.equals("") || pass.equals(""))
//                    Toast.makeText(getActivity(),"Please fill the fields",Toast.LENGTH_SHORT);
//                else {
//                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
//                    if (checkuserpass == true){
//                        Toast.makeText(getActivity(),"Log in succesfull",Toast.LENGTH_SHORT).show();
//                    Navigation.findNavController(requireView()).navigate(R.id.action_authActivity_to_homePageActivity);
//                    }
//                    else {Toast.makeText(getActivity(),"Invalid credentials", Toast.LENGTH_SHORT);
//                    }
//                }
//            }
//        });
    }

}