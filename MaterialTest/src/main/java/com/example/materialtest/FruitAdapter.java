package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by guojian on 2017/5/10.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mcContext;
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        ImageView mFruitImageView;
        TextView mFruitTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            mFruitImageView = (ImageView) itemView.findViewById(R.id.fruit_image);
            mFruitTextView = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcContext == null){
            mcContext = parent.getContext();
        }
        View view = LayoutInflater.from(mcContext).inflate(R.layout.fruit_item,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mcContext, "clicked cardddddd~~~~~", Toast.LENGTH_SHORT).show();
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent intent = new Intent(mcContext,FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageId());
                mcContext.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.mFruitTextView.setText(fruit.getName());
        Glide.with(mcContext).load(fruit.getImageId()).into(holder.mFruitImageView);


    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
