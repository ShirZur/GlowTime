package com.example.common;

import java.io.Serializable;
import java.util.ArrayList;

public class AppManager {
    private static AppManager instance;
    public ArrayList<AppointmentType> appointments = new ArrayList<>();
    public AppointmentType currentAppointment = null;
    public String name;


    public AppManager(DataManagerBase dataManagerBase) {
        this.appointments = dataManagerBase.getAppointments();
        this.name = dataManagerBase.getName();
    }

    public String[] getAppointmentsNames() {
        String[] appointmentNames = new String[9];
        for (int i = 0; i < appointments.size(); i++) {
            appointmentNames[i] = appointments.get(i).getAppointmentName();
        }
        return appointmentNames;
    }

    public AppointmentType getAppointmentByName(String name) {
        for (AppointmentType appointment : appointments) {
            if (appointment.getAppointmentName().equals(name)) {
                return appointment;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public static synchronized AppManager getInstance(DataManagerBase dataManagerBase) {
        if (instance == null) {
            instance = new AppManager(dataManagerBase);
        }
        return instance;
    }
}
