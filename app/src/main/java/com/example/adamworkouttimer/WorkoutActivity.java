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
        setContentView(R.layout.activity_workout);

        seconds = getIntent().getExtras().getInt("seconds");
        Log.i("INFO", "Seconds in Activity2 before passing to fragment are " + seconds);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, TimerFragment.newInstance(seconds))
                    .commit();
        }
    }
}