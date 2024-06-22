package com.example.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detailsActivity extends AppCompatActivity {
    TextView treatmentTypeValue;
    TextView appointmentDateValue ;
    TextView appointmentTimeValue ;
    String currentName;
    String currentDate;
    String currentTime;
    androidx.appcompat.widget.AppCompatButton next_level_details_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getIntentData();
        findViews();
        setVariable();
        setOnClick();

    }

    private void setVariable() {
        treatmentTypeValue.setText(currentName);
        appointmentDateValue.setText(currentDate);
        appointmentTimeValue.setText(currentTime);
    }

    private void getIntentData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentName = extras.getString("currentName");
            currentDate = extras.getString("currentDate");
            currentTime = extras.getString("currentTime");
        }
    }

    private void setOnClick() {
        next_level_details_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        treatmentTypeValue = findViewById(R.id.treatmentTypeValue);
        appointmentDateValue = findViewById(R.id.appointmentDateValue);
        appointmentTimeValue = findViewById(R.id.appointmentTimeValue);
        next_level_details_BTN = findViewById(R.id.next_level_details_BTN);
    }
}