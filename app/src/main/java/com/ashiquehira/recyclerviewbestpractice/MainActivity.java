package com.ashiquehira.recyclerviewbestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardClickListner{

    RecyclerView myRecyclerView;

    private ArrayList<MyModel> models = new ArrayList<>();
    private RecyclerAdapter myRecyclerAdapter;

    private ShimmerFrameLayout shimmerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        shimmerViewContainer = findViewById(R.id.myShimmo);
        shimmerViewContainer.setVisibility(View.VISIBLE);
        shimmerViewContainer.startShimmerAnimation();

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setVisibility(View.INVISIBLE);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerAdapter = new RecyclerAdapter(models,this);
        myRecyclerView.setAdapter(myRecyclerAdapter);

        insertDatas();
        if (insertDatas() && shimmerViewContainer.isAnimationStarted()){

            shimmerViewContainer.setVisibility(View.GONE);
            shimmerViewContainer.startShimmerAnimation();
            myRecyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        shimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
    public boolean insertDatas(){


        MyModel m = new MyModel();
        m.setMyTitle("Apple");
        m.setMyDisc("This is an apple");
        m.setMyImg(R.drawable.apple);

        models.add(m);


        m = new MyModel();
        m.setMyTitle("Orange");
        m.setMyDisc("This is an Orange");
        m.setMyImg(R.drawable.orange);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Watermelon");
        m.setMyDisc("This is a Watermelon");
        m.setMyImg(R.drawable.watermelon);
        m.setMyuid("this is my uid");
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Mango");
        m.setMyDisc("This is a Mango");
        m.setMyImg(R.drawable.mango);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Banana");
        m.setMyDisc("This is a Banana");
        m.setMyImg(R.drawable.banana);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Anar");
        m.setMyDisc("This is an Anar");
        m.setMyImg(R.drawable.anar);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Pineapple");
        m.setMyDisc("This is a Pineapple");
        m.setMyImg(R.drawable.pinapple);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Grape");
        m.setMyDisc("This is Grape");
        m.setMyImg(R.drawable.grape);
        models.add(m);

        return true;
    }

    @Override
    public void onCardClick(int position) {
        String gUid = models.get(position).getMyuid();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("uid",gUid);
        startActivity(intent);
    }
    // write some code here
}