package com.example.myfoodapp;

import android.graphics.drawable.Icon;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FoodDetailsFragment extends Fragment {

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_details, container, false);
//



        TextView textView = view.findViewById(R.id.foodtext1);
        TextView textView1 = view.findViewById(R.id.price);
        ImageView imageView = (ImageView) view.findViewById(R.id.food);
        Bundle bundle = this.getArguments();
        FoodContents contents = bundle.getParcelable("data");

        textView.setText(contents.getTxt1());
        textView1.setText(contents.getTxt2());
        imageView.setImageResource(contents.getImg());



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView1 = view.findViewById(R.id.backbtn3);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_foodDetailsFragment_to_homePageActivity);

            }
        });

        Button button = view.findViewById(R.id.addtocart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_foodDetailsFragment_to_cartFragment);
            }
        });
    }
}