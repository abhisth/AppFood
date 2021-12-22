package com.example.myfoodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinksDetailsFragment extends Fragment {
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drinks_details, container, false);

        TextView textView = view.findViewById(R.id.drinktext);
        TextView textView1 = view.findViewById(R.id.drinksprice);
        ImageView imageView = (ImageView) view.findViewById(R.id.drinksimg);
        Bundle bundle = this.getArguments();

        DrinksContents contents = bundle.getParcelable("drinksdata");
        textView.setText(contents.getName());
        textView1.setText(contents.getPrice());
        imageView.setImageResource(contents.getImg());
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        NavController navController = Navigation.findNavController(view);
//        ImageView imageView = view.findViewById(R.id.backbtn3);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navController.navigate(R.id.action_drinksDetailsFragment_to_homePageActivity);
//
//            }
//        });
//
//    }
}