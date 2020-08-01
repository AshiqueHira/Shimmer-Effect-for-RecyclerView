package com.ashiquehira.recyclerviewbestpractice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView headingTV;
    TextView discTV;
    ImageView imageV;

    //ShimmerFrameLayout shimmerFrameLayout;
    CardClickListner onCardClickListener;

    public RecyclerViewHolder(@NonNull View itemView, CardClickListner onCardClickListener) {
        super(itemView);

        //shimmerFrameLayout = itemView.findViewById(R.id.myShimmo);

        headingTV = itemView.findViewById(R.id.title);
        discTV = itemView.findViewById(R.id.discription);
        imageV = itemView.findViewById(R.id.imageIcon);

        this.onCardClickListener = onCardClickListener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onCardClickListener.onCardClick(getAdapterPosition());
    }
}
