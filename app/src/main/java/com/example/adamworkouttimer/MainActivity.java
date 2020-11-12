package com.example.adamworkouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.hourbtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.minbtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.secbtn)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), WorkoutActivity.class);
        switch (view.getId()) {
            case R.id.hourbtn:
                time = 5400;
                intent.putExtra("seconds", time);
                startActivity(intent);
                //Log.i("INFO", "From MainActivity 90 min button pushed, Time is " + time);
                break;
            case R.id.minbtn:
                time = 2100;
                intent.putExtra("seconds", time);
                startActivity(intent);
                break;
            case R.id.secbtn:
                time = 30;
                intent.putExtra("seconds", time);
                startActivity(intent);
        }
    }
    /*  public void WorkoutBtn90(View view)
    {
        Intent intent = new Intent(getApplicationContext(), WorkoutActivity.class);
        int time = 5400;
        intent.putExtra("seconds", time);
        startActivity(intent);
    }

    public void WorkoutBtn35(View view)
    {
        Intent intent = new Intent(getApplicationContext(), WorkoutActivity.class);
        int time = 2100;
        intent.putExtra("seconds", time);
        startActivity(intent);
    }

    public void WorkoutBtn30S(View view)
    {
        Intent intent = new Intent(getApplicationContext(), WorkoutActivity.class);
        int time = 30;
        intent.putExtra("seconds", time);
        startActivity(intent);
    }
    */

}