package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class recyclerActivity extends AppCompatActivity implements myAdapter.IOnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private myAdapter mAdapter;
    private TextView refreshTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_recycler);
        refreshTime = (TextView) findViewById(R.id.refresh_time);
        Date date = new Date();
        String time = date.toString();
        Log.d("TAG", "time: " + time);
        refreshTime.setText("更新于 " + time);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        mAdapter = new myAdapter(testDataset.getData());
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        DefaultItemAnimator animator =new DefaultItemAnimator();
        animator.setAddDuration(2000);
        recyclerView.setItemAnimator(animator);

    }

    @Override
    public void onItemClick(int position, testData data) {
        mAdapter.addData(position+1, new testData("新增", "0w"));
        Log.d("TAG", "add");
    }

    @Override
    public void onItemLongClick(int position, testData data){
        mAdapter.removeData(position);
    }
}
