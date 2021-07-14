package com.example.chapter3.homework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class HelloFragment extends Fragment {

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                                @Nullable ViewGroup container,
                                @Nullable Bundle savedInstanceState) {

        // LottieAnimationView lottieView = (LottieAnimationView) findViewById(R.id.lottie_view);
        return inflater.inflate(R.layout.activity_hello_fragment, container, false);
    }

}
