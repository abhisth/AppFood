package com.example.myfoodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DrinksFragment extends Fragment {

   RecyclerView recyclerView;
   drinkadapter drinkadapter;
   RecyclerView.LayoutManager layoutManager;
   ArrayList<DrinksContents> drinksholder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        recyclerView = view.findViewById(R.id.rviewdrinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        drinksholder = new ArrayList<>();

        DrinksContents ob1 = new DrinksContents(R.drawable.jd,"Jack Daniels", "$ 69.99");
        drinksholder.add(ob1);
        DrinksContents ob2 = new DrinksContents(R.drawable.od,"Old Durbar", "$ 49.99");
        drinksholder.add(ob2);
        DrinksContents ob3 = new DrinksContents(R.drawable.blacklbl,"Johnie walker-Black", "$ 79.99");
        drinksholder.add(ob3);
        DrinksContents ob4 = new DrinksContents(R.drawable.redlbl,"Johnie walker-Red", "$ 69.99");
        drinksholder.add(ob4);

        recyclerView.setAdapter(new drinkadapter(drinksholder));




        return view;
    }
}