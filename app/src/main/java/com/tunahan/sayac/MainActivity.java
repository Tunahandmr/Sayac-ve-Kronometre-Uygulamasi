package com.tunahan.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
TextView textView;
Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button6 = findViewById(R.id.button6);
    }


    public void timer(View view){

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void go1(View view){
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
             textView.setText("Time : "+l/1000);

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"finish",Toast.LENGTH_LONG).show();
                textView.setText("Finished");
            }
        }.start();
        button6.setEnabled(false);

    }



}
