package com.example.myfoodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        DBHelper DB = new DBHelper(getActivity());
        EditText editText = view.findViewById(R.id.editemail);
        EditText editText1 = view.findViewById(R.id.editpassword);
        EditText editText2 = view.findViewById(R.id.editrepass);
        Button button = view.findViewById(R.id.Signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =editText.getText().toString();
                String pass = editText1.getText().toString();
                String repass = editText2.getText().toString();

                if(user.equals("") && pass.equals("") && repass.equals(""))
                    Toast.makeText(getActivity(),"Please enter all the fields" , Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername (user);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert == true){
                                Toast.makeText(getActivity(),"Registered succesfully",Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(requireView()).navigate(R.id.action_authActivity_to_registersuccessFragment);
                            }
                            else
                                Toast.makeText(getActivity(),"Registration failed", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getActivity(),"Username already exists",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getActivity(),"Passwords donot match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        DBHelper DB = new DBHelper(getActivity());
//        EditText editText = view.findViewById(R.id.editemail);
//        EditText editText1 = view.findViewById(R.id.editpassword);
//        EditText editText2 = view.findViewById(R.id.editrepass);
//        Button button = view.findViewById(R.id.Signup);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String user =editText.getText().toString();
//                String pass = editText1.getText().toString();
//                String repass = editText2.getText().toString();
//
//                if(user.equals("") && pass.equals("") && repass.equals(""))
//                    Toast.makeText(getActivity(),"Please enter all the fields" , Toast.LENGTH_SHORT);
//                else{
//                    if(pass.equals(repass)){
//                        Boolean checkuser = DB.checkusername (user);
//                        if (checkuser == false){
//                            Boolean insert = DB.insertData(user,pass);
//                            if(insert == true){
//                                Toast.makeText(getActivity(),"Registered succesfully",Toast.LENGTH_SHORT);
//                                Navigation.findNavController(requireView()).navigate(R.id.action_authActivity_to_homePageActivity);
//
//                            }
//                            else
//                                Toast.makeText(getActivity(),"Registration failed", Toast.LENGTH_SHORT);
//                        }
//                        else
//                            Toast.makeText(getActivity(),"Username already exists",Toast.LENGTH_SHORT);
//                    }
//                }
//            }
//        });
    }
}