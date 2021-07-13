package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    private Button practiceActivityBtn, baiduBtn, callBtn, recyclerBtn, UIBtn;
    private static final String TAG = "TAG";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "myActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "myActivity: onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "myActivity onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "myActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "myActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "myActivity onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.i(TAG, "onCreate");

        practiceActivityBtn = (Button) findViewById(R.id.practiceActivity);
        baiduBtn = (Button) findViewById(R.id.baidu);
        callBtn = (Button) findViewById(R.id.call);
        recyclerBtn = (Button) findViewById(R.id.recycler);
        UIBtn = (Button) findViewById(R.id.UI);

        practiceActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, practiceActivity.class);
                startActivity(intent);
            }
        });

        baiduBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(intent);
            }
        });

        recyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, recyclerActivity.class);
                startActivity(intent);
            }
        });

        UIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, UIActivity.class);
                startActivity(intent);
            }
        });
/*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyActivity.this, "Button click", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}
