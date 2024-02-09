package com.example.meals;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meals.getAllmeals.AllMealLisenter;
import com.example.meals.model.Meals;

import java.util.List;

public class AllmealsAdapter extends RecyclerView.Adapter<AllmealsAdapter.MyViewHolder>{
    Context context;
    List<Meals> myList;
    AllMealLisenter productsListener;
    public AllmealsAdapter(Context context, List<Meals> myList, AllMealLisenter listener)
    {
        productsListener=listener;
        this.context=context;
        this.myList=myList;

    }
    public void setMyList(List<Meals> myList)
    {
        this.myList.addAll(myList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_all,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textOne.setText("hihihi"+myList.get(position).getStrMeal());
        /*holder.textOne.setText(myList.get(position).getStrCategory());
        holder.textTwo.setText(myList.get(position).getStrCategoryDescription());
        Glide.with(context).load(myList.get(position).getStrCategoryThumb()).into(holder.img);
        holder.btnAddFav.setOnClickListener(v -> {
            productsListener.addOnClickLister(myList.get(position));
        });
        Log.i("TAG", "onBindViewHolder: "+myList.get(position).getStrCategoryThumb());
*/
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textOne;
        TextView textTwo;
        Button btnAddFav;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.imageView2);
            textOne=itemView.findViewById(R.id.tvOneAll);
            textTwo=itemView.findViewById(R.id.tvTwoAll);
            btnAddFav=itemView.findViewById(R.id.btnAddFavAll);
        }
    }

}
