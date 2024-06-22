package com.example.barbershop;

import android.util.Log;

import com.example.common.AppointmentType;
import com.example.common.DataManagerBase;

import java.util.ArrayList;

public class DataManager extends DataManagerBase {

    @Override
    public ArrayList<AppointmentType> getAppointments() {
        String[] availableHours = {"10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17:30", "18:30"};

        appointments.add(new AppointmentType()
                .setAppointmentName("גוונים").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("החלקה יפנית").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("תספורת אישה").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("צבע").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("שיקום שיער").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("תספורת גבר").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("החלקה אורגנית").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("החלקת קראטין").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("פגישת ייעוץ").setHoursAvailable(availableHours));
        return appointments;
    }

    @Override
    public String getName() {
        return "מספרת שמפו";
    }
}

