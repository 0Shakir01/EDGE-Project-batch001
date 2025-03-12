package com.calculator.simplecaculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {



    private ProgressBar progressBar;
    int progressNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //Progress Method call
                doWprk();

                //Next Page Call
                startApp();

            }
        });
        thread.start();



    }
    public void doWprk(){
        for (progressNum=20;progressNum<=100;progressNum+=20){
            try {
                Thread.sleep(600);
                progressBar.setProgress(progressNum);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void startApp(){
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();







    }
}