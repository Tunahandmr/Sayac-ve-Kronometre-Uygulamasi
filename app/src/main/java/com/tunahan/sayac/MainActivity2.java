package com.tunahan.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
Runnable runnable;
Handler handler;
int number;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button2);
        number =0;
    }



    public void counter(View view){

        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
    public void go(View view){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : "+number);
                number++;
                textView.setText("Time : "+number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }

    public void reset(View view){

        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Time : "+number);
    }

    public void stop(View view){

        button.setEnabled(true);
        handler.removeCallbacks(runnable);

    }
}