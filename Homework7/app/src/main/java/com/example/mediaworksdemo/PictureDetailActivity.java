package com.example.mediaworksdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PictureDetailActivity extends AppCompatActivity {
    // String mockUrl = "https://tuna.moe/assets/img/logo-small@2x.png";
    // String host = "tuna.moe";
    String mockUrl = "https://lf1-cdn-tos.bytescm.com/obj/static/ies/bytedance_official_cn/_next/static/images/0-390b5def140dc370854c98b8e82ad394.png";
    String mockErrorUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/400px-Android_logo_2019_%28stacked%29.svg.pn";
    String UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    String host = "lf1-cdn-tos.bytescm.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        ImageView imageView = findViewById(R.id.iv_detail);
        Button btnSuccess = findViewById(R.id.btn_load_success);
        Button btnFail = findViewById(R.id.btn_load_fail);
        Button btnRoundedCorners = findViewById(R.id.btn_rounded_corners);
        Button btnTransition = findViewById(R.id.btn_transition);

        GlideUrl glideMockUrl = new GlideUrl(mockUrl, new LazyHeaders.Builder()
                                            .addHeader("User-Agent", UA)
                                            .addHeader("Host", host)
                                            .build());

        btnSuccess.setOnClickListener( v -> {
            Glide.with(this).load(glideMockUrl)
                    .placeholder(R.drawable.ic_cloud_download_white_24dp)
                    .apply(new RequestOptions().centerCrop())
                    .error(R.drawable.ic_cancel_white_24dp)
                    .into(imageView);
        });

        btnFail.setOnClickListener( v -> {
            Glide.with(this).load(mockErrorUrl)
                    .placeholder(R.drawable.ic_cloud_download_white_24dp)
                    .apply(new RequestOptions().centerCrop())
                    .error(R.drawable.ic_cancel_white_24dp)
                    .into(imageView);
        });

        btnRoundedCorners.setOnClickListener( v-> {
            DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build();

            Glide.with(this).load(mockUrl)
                    .placeholder(R.drawable.ic_cloud_download_white_24dp)
                    .error(R.drawable.ic_cancel_white_24dp)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                    .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                    .into(imageView);
        });


        DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder(500).setCrossFadeEnabled(true).build();
        btnTransition.setOnClickListener( v -> {
            Glide.with(this).load(mockUrl)
                    .placeholder(R.drawable.ic_cloud_download_white_24dp)
                    .error(R.drawable.error_red)
                    .apply(new RequestOptions().centerCrop())
                    .transition(withCrossFade(drawableCrossFadeFactory))
                    .into(imageView);
        });
    }
}
