package com.example.adamworkouttimer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TimerFragment extends Fragment {

    private int seconds;
    private TextView tv;
    private boolean paused = true;
    private FloatingActionButton fab;
    private Drawable PLAY;
    private Drawable PAUSE;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = view.findViewById(R.id.time_text);
        fab = view.findViewById(R.id.play_pause_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paused = !paused;
                setIcon();
            }
        });
        PLAY = getResources().getDrawable(android.R.drawable.ic_media_pause);
        PAUSE = getResources().getDrawable(android.R.drawable.ic_media_play);
        //I hard coded seconds to equal 30 since I was still not able to figure out why the app was not passing around the
            // variable correctly.  TimerFragment below would get the correct number of seconds from the button pushed but I am stuck
            // on what to do next.
        //seconds = getArguments().getInt("time");
        seconds = 30;
        if (savedInstanceState != null) {
            paused = savedInstanceState.getBoolean("paused");
            seconds = savedInstanceState.getInt("seconds");
            setIcon();
        }
        runTimer();
    }

    public static TimerFragment newInstance(int seconds) {
        TimerFragment tf = new TimerFragment();
        Bundle args = new Bundle();
        Log.i("INFO", "Seconds from TimerFragment are " + seconds);
        args.putInt("time", seconds);
        tf.setArguments(args);
        return tf;
    }

    private void setIcon() {
        Drawable icon = paused ? PAUSE : PLAY;
        fab.setImageDrawable(icon);
    }

    public void runTimer() {

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                int sec = seconds % 60;
                int min = (seconds % 3600) / 60;
                int hour = seconds / 3600;
                //Log.i("INFO", "Seconds is " + seconds);
                tv.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                if (!paused)
                    seconds--;
                if (seconds == 0) {
                    paused = true;
                    fab.hide();
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
