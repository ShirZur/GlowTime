package com.example.common;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AppointmentActivity extends AppCompatActivity {
    GridLayout gridLayout_appointment;

    androidx.appcompat.widget.AppCompatButton next_level_appointment_BTN;
    String currentName;
    private AppManager appManager;
    protected DataManagerBase dataManagerBase;
    private Button lastSelectedButton = null;
    ImageView arrow_back_appointment_BTN;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        findViews();
        setOnClick();
        setupGridLayout();

    }
    private void setupGridLayout() {
        String[] meetingTypes = MainActivityBase.appManager.getAppointmentsNames();

        for (String name : meetingTypes)
        {
            Button button = new Button(AppointmentActivity.this);
            button.setText(name);
            button.setBackgroundResource(R.drawable.hour_rounded_button);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.setMargins(8, 8, 8, 8);
            button.setLayoutParams(params);
            gridLayout_appointment.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (lastSelectedButton != null && lastSelectedButton != button) {
                        lastSelectedButton.setBackgroundResource(R.drawable.hour_rounded_button);
                        lastSelectedButton.setTypeface(null, Typeface.NORMAL);
                    }
                    button.setBackgroundResource(R.drawable.hour_rounded_button_v2);
                    button.setTypeface(null, Typeface.BOLD);
                    next_level_appointment_BTN.setBackgroundResource(R.drawable.rounded_button);
                    currentName = button.getText().toString();
                    lastSelectedButton = button;

                }
            });
        }
    }

    private void setOnClick() {
        next_level_appointment_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppointmentActivity.this, CalendarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("currentName", currentName);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void findViews() {
        gridLayout_appointment = findViewById(R.id.gridLayout_appointment);
        next_level_appointment_BTN = findViewById(R.id.next_level_appointment_BTN);
        arrow_back_appointment_BTN = findViewById(R.id.arrow_back_appointment_BTN);
    }
}