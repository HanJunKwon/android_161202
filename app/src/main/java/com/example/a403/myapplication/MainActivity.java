package com.example.a403.myapplication;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    Chronometer cm;
    CalendarView cv;
    TimePicker tp;
    Button btn1, btn2;
    RadioGroup rg;
    TextView tv;
    String str;
    String str2;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201344080 권한준");
        cm = (Chronometer) findViewById(R.id.chronometer2);
        tv = (TextView) findViewById(R.id.textView);

        setCalerendarView();
        setTimePicker();
        setButton();
        setRadioGroup();
    }

    void setTimePicker() {
        tp = (TimePicker) findViewById(R.id.timePicker);
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                str2 = hourOfDay + "시" + minute + "분";
            }
        });
    }

    void setCalerendarView() {
        cv = (CalendarView) findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                str = year + "년" + (month + 1) + "월" + dayOfMonth + "일";
            }
        });
    }


    void setButton() {
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==true)
                    return;
                check = true;
                cm.setBase(SystemClock.elapsedRealtime());
                cm.start();
                cm.setTextColor(Color.RED);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == false) {
                    Toast.makeText(getApplicationContext(), "예약 시작 버튼을 누르세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (str == null) {
                    Toast.makeText(getApplicationContext(), "예약 날짜를 선택하셔야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (str2 == null) {
                    Toast.makeText(getApplicationContext(), "예약 시간을 선택하셔야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                check = false;
                cm.stop();
                cm.setTextColor(Color.BLUE);
                tv.setText(str + str2 + " 예약 됨");
            }
        });
    }

    void setRadioGroup() {
        rg = (RadioGroup) findViewById(R.id.raioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    cv.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.INVISIBLE);
                } else if (checkedId == R.id.radioButton2) {
                    cv.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
