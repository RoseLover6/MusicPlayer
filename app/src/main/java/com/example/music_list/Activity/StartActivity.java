package com.example.music_list.Activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.example.music_list.R;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent intent = new Intent(StartActivity.this, LoginActivity.class);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
