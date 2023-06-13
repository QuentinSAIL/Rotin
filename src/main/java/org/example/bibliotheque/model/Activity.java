package org.example.bibliotheque.model;

import java.util.Date;

public class Activity {
    private String name;
    private int duration;
    private Date date;
    private int RPE;
    private int load;

    public Activity(String name, int duration, Date date, int RPE, int load) {
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.RPE = RPE;
        this.load = load;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRPE() {
        return RPE;
    }

    public void setRPE(int RPE) {
        this.RPE = RPE;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", RPE=" + RPE +
                ", load=" + load +
                '}';
    }
}
