package com.example.myfoodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentStateAdapter {
    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new SignupFragment();
        }
        return new LoginFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

class PageAdapter1 extends FragmentStateAdapter{

    public PageAdapter1(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new FoodsFragment();
        }
        else if (position == 1){
        return new DrinksFragment();
    }
        else if (position == 2){
        return new SnacksFragment();
    }
        else if (position == 3){
        return new DrinksFragment();
    }
        else {return new SnacksFragment();} }

    @Override
    public int getItemCount() {
        return 5;
    }
}

class foodadapter extends RecyclerView.Adapter<foodadapter.myviewholder> {
ArrayList<FoodContents> foodholder;
RecyclerView recyclerView;

    public foodadapter(ArrayList<FoodContents> foodholder) {
        this.foodholder = foodholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodrv,parent,false);


        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.imageView.setImageResource(foodholder.get(position).getImg());
        holder.textView1.setText(foodholder.get(position).getTxt1());
        holder.textView2.setText(foodholder.get(position).getTxt2());
    }

    @Override
    public int getItemCount() {
        return foodholder.size() ;
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1, textView2;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.food);
            textView1 = itemView.findViewById(R.id.foodtext);
            textView2 = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle =new Bundle();
                    bundle.putParcelable("data",foodholder.get(getAdapterPosition()));

NavController navController = Navigation.findNavController(itemView);
navController.navigate(R.id.action_homePageActivity_to_foodDetailsFragment,bundle);


                }
            });


        }
    }
}


class drinkadapter extends RecyclerView.Adapter<drinkadapter.myviewholder> {
    ArrayList<DrinksContents> drinksholder;
    RecyclerView recyclerView;

    public drinkadapter(ArrayList<DrinksContents> drinksholder) {
        this.drinksholder = drinksholder;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodrv,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.imageView.setImageResource(drinksholder.get(position).getImg());
        holder.textView1.setText(drinksholder.get(position).getName());
        holder.textView2.setText(drinksholder.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return drinksholder.size() ;
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1, textView2;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food);
            textView1 = itemView.findViewById(R.id.foodtext);
            textView2 = itemView.findViewById(R.id.price);

            imageView = (ImageView) itemView.findViewById(R.id.food);
            textView1 = itemView.findViewById(R.id.foodtext);
            textView2 = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle =new Bundle();
                    bundle.putParcelable("drinksdata",drinksholder.get(getAdapterPosition()));

                    NavController navController = Navigation.findNavController(itemView);
                    navController.navigate(R.id.action_homePageActivity_to_drinksDetailsFragment,bundle);


                }
            });


        }
    }
}