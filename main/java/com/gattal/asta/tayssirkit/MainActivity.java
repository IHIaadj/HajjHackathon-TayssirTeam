package com.gattal.asta.tayssirkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ListItemClickListener {

    private RecyclerViewAdapter mAdapter;
    private RecyclerView mMainRecyclerView;
    private String[] choices = new String[]{"دليل الحاج","معلومات الحركة المرورية","الإبلاغ عن مشكلة","من نحن"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainRecyclerView = findViewById(R.id.MainRecyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Setting The recycler view with it's Adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMainRecyclerView.setLayoutManager(layoutManager);
        mMainRecyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(4,this);
        mMainRecyclerView.setAdapter(mAdapter);

        mAdapter.setData(choices);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = null;
        switch (clickedItemIndex){
            case 1:
                intent = new Intent(getApplicationContext(), GuideHajjMainActivity.class);
                break;
            case 2:
                intent = new Intent(getApplicationContext(), GuideHajjMainActivity.class);
                break;
            case 3:
                intent = new Intent(getApplicationContext(), ReportProblemMainActivity.class);
                break;
            case 4:
                intent = new Intent(getApplicationContext(), AboutMainActivity.class);
                break;
        }


        startActivity(intent);
    }
}
