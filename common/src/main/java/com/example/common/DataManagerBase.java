package com.example.common;

import java.util.ArrayList;

public abstract class DataManagerBase {
    public static ArrayList<AppointmentType> appointments = new ArrayList<>();
    public static String name;



    public abstract  ArrayList<AppointmentType> getAppointments();
    public abstract  String getName();


}
