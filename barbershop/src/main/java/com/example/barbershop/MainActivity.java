package com.example.barbershop;

import android.os.Bundle;

import com.example.common.MainActivityBase;

public class MainActivity extends MainActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManager();
        super.onCreate(savedInstanceState);

    }
}