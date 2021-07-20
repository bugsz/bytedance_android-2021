package com.example.mediaworksdemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VideoDetailActivity extends AppCompatActivity {

    String mockUrl = "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218114723HDu3hhxqIT.mp4";

    private SeekBar seekBar;
    private TextView textViewProgress;
    private TextView textViewDuration;
    private VideoView videoView;

    private int currentTime;
    private boolean isIntervened = false;
    private Handler handler = new Handler();
    private Runnable updateCursorRunnable = new Runnable() {
        @Override
        public void run() {
            if(videoView.isPlaying() && isIntervened == false) {
                currentTime = videoView.getCurrentPosition();
                textViewProgress.setText(getTime(currentTime));
                seekBar.setProgress(currentTime);
            }
            handler.postDelayed(updateCursorRunnable, 50);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        videoView = findViewById(R.id.vv_detail);
        textViewDuration = findViewById(R.id.duration);
        textViewProgress = findViewById(R.id.progress);
        seekBar = findViewById(R.id.progress_bar);

        setTextView();
        setSeekBar();

        setVideoUri(); // 支持从系统文件中获取
        setVideoView();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(videoView != null) outState.putInt("currentTime", currentTime);
    }

    private void setVideoUri() {
        Intent intent = getIntent();
        if(intent != null && Intent.ACTION_VIEW.equals(intent.getAction()))
            videoView.setVideoURI(intent.getData());
        else videoView.setVideoURI(Uri.parse(mockUrl));
    }

    private void play() {

    }

    private void setVideoView() {

        // videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(videoView.isPlaying()) videoView.pause();
                else videoView.start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                textViewDuration.setText(getTime(videoView.getDuration()));
                seekBar.setMax(videoView.getDuration());
                videoView.seekTo(currentTime > 0 ? currentTime : 0);
                videoView.start();
                handler.post(updateCursorRunnable);

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // 好像没啥要做的

            }
        });
    }

    private void setSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 不用更新
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isIntervened = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(!videoView.isPlaying()) videoView.start();
                int progress = seekBar.getProgress();
                videoView.seekTo(progress);
                isIntervened = false;
            }
        });
    }

    private void setTextView() {

    }

    private String getTime(long timeMilli) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMilli);
        return new SimpleDateFormat("mm:ss")
                .format(calendar.getTime());
    }
}
