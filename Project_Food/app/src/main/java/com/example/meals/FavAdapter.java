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
import com.example.meals.FavMeals.FavLisneter;
import com.example.meals.model.Meals;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder>{
    Context context;
    List<Meals> myList;
    FavLisneter favoriteListener;
    public FavAdapter(Context context, List<Meals> myList, FavLisneter listener)
    {
        favoriteListener=listener;
        this.context=context;
        this.myList=myList;
    }
    public void setMyList(List<Meals> myList)
    {
        this.myList=myList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_fav,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //holder.textOne.setText(myList.get(position).getStrCategory());
        //holder.textTwo.setText(""+myList.get(position).getStrCategoryDescription());
        //Glide.with(context).load(myList.get(position).getStrCategoryThumb()).into(holder.img);
        holder.btnDeleteFav.setOnClickListener(v -> {
            favoriteListener.onRemoveListener(myList.get(position));
        });
        //Log.i("TAG", "onBindViewHolder: "+myList.get(position).getStrCategoryThumb());

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textOne;
        TextView textTwo;
        Button btnDeleteFav;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.imageView);
            textOne=itemView.findViewById(R.id.textView);
            textTwo=itemView.findViewById(R.id.textView2);
            btnDeleteFav=itemView.findViewById(R.id.button);
        }
    }


}
