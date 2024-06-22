package com.example.common;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    GridLayout gridLayout_calendar;
    androidx.appcompat.widget.AppCompatButton next_level_calender_BTN;
    ImageView arrow_back_calendar_BTN;
    String currentName;
    String currentDate;
    String currentTime;
    private Button lastSelectedButton = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        getIntentData();
        findViews();
        setOnClick();


    }

    private void getIntentData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentName = extras.getString("currentName");
        }
    }

    private void setupGridLayout() {
        String[] availableHours = MainActivityBase.appManager.getAppointmentByName(currentName).getHoursAvailable();
        for (String hour : availableHours) {
            Button button = new Button(CalendarActivity.this);
            button.setText(hour);
            button.setBackgroundResource(R.drawable.hour_rounded_button);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = GridLayout.LayoutParams.WRAP_CONTENT;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.setMargins(8, 8, 8, 8);
            button.setLayoutParams(params);
            gridLayout_calendar.addView(button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (lastSelectedButton != null && lastSelectedButton != button) {
                        lastSelectedButton.setBackgroundResource(R.drawable.hour_rounded_button);
                        lastSelectedButton.setTypeface(null, Typeface.NORMAL);
                    }
                    button.setBackgroundResource(R.drawable.hour_rounded_button_v2);
                    button.setTypeface(null, Typeface.BOLD);
                    next_level_calender_BTN.setBackgroundResource(R.drawable.rounded_button);
                    currentTime = hour;
                    lastSelectedButton = button;

                }
            });

        }
    }

    private void setOnClick() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                gridLayout_calendar.removeAllViews();
                currentDate = i + "-"+ (i1-1) +"-" +i2;
                setupGridLayout();

            }
        });
        arrow_back_calendar_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        next_level_calender_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, detailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("currentName", currentName);
                bundle.putString("currentDate", currentDate);
                bundle.putString("currentTime", currentTime);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        calendarView = findViewById(R.id.calendarView);
        gridLayout_calendar = findViewById(R.id.gridLayout_calendar);
        next_level_calender_BTN = findViewById(R.id.next_level_calender_BTN);
        arrow_back_calendar_BTN = findViewById(R.id.arrow_back_calendar_BTN);
    }
}