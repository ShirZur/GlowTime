package com.example.common;

public class AppointmentType {

    private String appointmentName;
    private String[] hoursAvailable = new String[]{};


    public AppointmentType() {

    }
    public AppointmentType(String appointmentName, String[] hoursAvailable) {
        this.appointmentName = appointmentName;
        this.hoursAvailable = hoursAvailable;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public AppointmentType setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
        return this;
    }

    public String[] getHoursAvailable() {
        return hoursAvailable;
    }

    public AppointmentType setHoursAvailable(String[] hoursAvailable) {
        this.hoursAvailable = hoursAvailable;
        return this;
    }
}
