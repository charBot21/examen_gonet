package com.vu.carlost.examen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final int ss = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //indicamos que la orientación de la pantalla será vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //Codigo SplashScreen
        final Intent i = new Intent(this, LoginActivity.class);
        Thread timer = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(ss);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };timer.start();
    }//onCreate
}

