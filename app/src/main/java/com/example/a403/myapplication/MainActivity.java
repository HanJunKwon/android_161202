package com.example.a403.myapplication;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {
    CalendarView cv;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201344080 권한준");
        cv = (CalendarView)findViewById(R.id.calendarView);
        tp = (TimePicker)findViewById(R.id.timePicker);

        setButton();
    }
}
