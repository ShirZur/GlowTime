package com.example.newapp;


import com.example.common.AppointmentType;
import com.example.common.DataManagerBase;

import java.util.ArrayList;

public class DataManager extends DataManagerBase {

    @Override
    public ArrayList<AppointmentType> getAppointments() {
        String[] availableHours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};

        appointments.add(new AppointmentType()
                .setAppointmentName("טיפול פנים קלאסי").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("טיפול פנים אנטי אייג'ינג").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("איפור קבוע").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("הסרת שיער").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("לק ג'ל").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("פדיקור").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("מניקור").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("בניית ציפורניים").setHoursAvailable(availableHours));
        appointments.add(new AppointmentType()
                .setAppointmentName("טיפול פנים רפואי").setHoursAvailable(availableHours));
        return appointments;
    }

    @Override
    public String getName() {
        return "שיר צור";
    }
}
