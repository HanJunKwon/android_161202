package com.example.a403.myapplication;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {
    Chronometer cm;
    CalendarView cv;
    TimePicker tp;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201344080 권한준");
        cv = (CalendarView)findViewById(R.id.calendarView);
        tp = (TimePicker)findViewById(R.id.timePicker);
        cm = (Chronometer)findViewById(R.id.chronometer2);


        setButton();
    }

    void setButton(){
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.start();
                cm.setTextColor(Color.RED);
            }
        });
    }
}
