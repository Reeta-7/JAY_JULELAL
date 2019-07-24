package com.example.reetadhinglani.jay_julelal;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    int DELAY_IN_SECOND = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        pauseForSomeTime();
    }
    private void pauseForSomeTime() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendUser();
            }
        },DELAY_IN_SECOND);
    }

    private void sendUser() {
        Intent SwitchIntent = new Intent(this,select_lang.class);
        startActivity(SwitchIntent);
        finish();
    }
}
