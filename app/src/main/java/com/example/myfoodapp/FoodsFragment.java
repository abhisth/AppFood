package com.example.myfoodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class FoodsFragment extends Fragment {
    RecyclerView recyclerView;
    foodadapter foodadapter1;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FoodContents> foodholder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);
        recyclerView = view.findViewById(R.id.RvFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        foodholder = new ArrayList<>();

        FoodContents ob1 = new FoodContents(R.drawable.dish1,"Dish num 1", "$ 19.99");
        foodholder.add(ob1);
        FoodContents ob2 = new FoodContents(R.drawable.dish1,"Dish num 2", "$ 19.99");
        foodholder.add(ob2);
        FoodContents ob3 = new FoodContents(R.drawable.dish1,"Dish num 3", "$ 19.99");
        foodholder.add(ob3);
        FoodContents ob4 = new FoodContents(R.drawable.dish1,"Dish num 4", "$ 19.99");
        foodholder.add(ob4);

        recyclerView.setAdapter(new foodadapter(foodholder));



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}