package com.example.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;


public class MainActivityBase extends AppCompatActivity {
    androidx.appcompat.widget.AppCompatButton appointmentBTN;
    protected DataManagerBase dataManagerBase;
    public static AppManager appManager;
    TextView name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appManager = AppManager.getInstance(dataManagerBase);
        findViews();
        setValues();
        setOnClick();
    }

    private void setValues() {
        name.setText(appManager.getName());
    }


    private void setOnClick() {
        appointmentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityBase.this, AppointmentActivity.class);
                startActivity(intent);
           }
        });
    }

    private void findViews() {
        appointmentBTN = findViewById(R.id.appointmentBTN);
        name = findViewById(R.id.name);
    }
}