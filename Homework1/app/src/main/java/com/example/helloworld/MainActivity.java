package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button submitButton;
    private EditText eatFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.true_feedback, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "吃");
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.false_feedback, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "不吃");
            }
        });

        submitButton = (Button) findViewById(R.id.go_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eatFood = (EditText) findViewById(R.id.eat_text);
                String food = eatFood.getText().toString();
                Log.d("MainActivity", Integer.toString(food.length()));
                if(food.length() == 0) Toast.makeText(MainActivity.this, "你啥都不想吃", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "你想吃："+food, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
