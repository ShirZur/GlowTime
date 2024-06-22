package com.example.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.common.MainActivityBase;


public class MainActivity extends MainActivityBase {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManager();

        super.onCreate(savedInstanceState);
    }



}