package com.example.adamworkouttimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WorkoutActivity extends AppCompatActivity {

    private int seconds;
    /*private TextView tv;
    private boolean paused = true;
    private FloatingActionButton fab;
    private Drawable PLAY;
    private Drawable PAUSE;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //When I try to comment out the line below the app crashes with this warning.
        //java.lang.IllegalArgumentException: No view found for id 0x7f08007f (com.example.adamworkouttimer:id/fragment_container)
        // for fragment TimerFragment{d7b689c (3c6f6323-471f-45d4-9f93-ff5271f60401) id=0x7f08007f}
        // I tried other things to only load 1 timer but have not gotten it to work yet.
        setContentView(R.layout.activity_workout);

        seconds = getIntent().getExtras().getInt("seconds");
        Log.i("INFO", "Seconds in Act2 before passing to fragment are " + seconds);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, TimerFragment.newInstance(seconds))
                    .commit();
        }
        //Kept some of my original code that I was able to get working perfectly before I switched the logic over to the TimerFragment.
        /*tv = findViewById(R.id.time_text);
        fab = findViewById(R.id.play_pause_fab);
        PLAY = getResources().getDrawable(android.R.drawable.ic_media_pause);
        PAUSE = getResources().getDrawable(android.R.drawable.ic_media_play);
        if (savedInstanceState != null) {
            paused = savedInstanceState.getBoolean("paused");
            seconds = savedInstanceState.getInt("seconds");
            setIcon();
        }
        runTimer();*/
    }

    /*private void setIcon() {
        Drawable icon = paused ? PAUSE : PLAY;
        fab.setImageDrawable(icon);
    }*/

    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("paused", paused);
    }*/

    /*public void startTimer(View view) {
        paused = !paused;
        setIcon();
    }*/

    /*public void runTimer() {
        final Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i("INFO", "Seconds down in the run timer method is " + seconds);
                int sec = seconds % 60;
                int min = (seconds % 3600) / 60;
                int hour = seconds / 3600;
                Log.i("INFO", "Seconds is " + seconds);
                tv.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                if (!paused)
                    seconds--;
                if (seconds == 0) {
                    paused = true;
                    setIcon();
                    fab.hide();
                }
                handler.postDelayed(this, 1000);
            }
        });
    }*/
}