package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LottieAnimationView mLottieView;
    private View animationView, recyclerView;
    private myAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        super.onCreate(savedInstanceState);
        Log.d("TAG", "createview");

        animationView = (View) container.findViewById(R.id.lottie_view);
        recyclerView = (View) container.findViewById(R.id.recycler_view);

        View currView = inflater.inflate(R.layout.fragment_placeholder, container, false);
        mRecyclerView = (RecyclerView) currView.findViewById(R.id.recycler_view);
        mLottieView = (LottieAnimationView) currView.findViewById(R.id.lottie_view);
        mContext = container.getContext();

        return currView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG", "created");

        mAdapter = new myAdapter(testDataset.getData());
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                Log.d("TAG", "run");
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator lottie_faded_animator = ObjectAnimator.ofFloat(mLottieView,
                        "alpha", 1.0f, 0.0f);
                lottie_faded_animator.setDuration(50);
                lottie_faded_animator.setRepeatCount(0);

                ObjectAnimator recycler_show_animator = ObjectAnimator.ofFloat(mRecyclerView,
                        "alpha", 0.0f, 1.0f);
                recycler_show_animator.setDuration(50);
                recycler_show_animator.setRepeatCount(0);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(lottie_faded_animator, recycler_show_animator);
                animatorSet.start();
            }
        }, 5000);
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("TAG", "stopped");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("TAG", "destroyed");
    }
}
