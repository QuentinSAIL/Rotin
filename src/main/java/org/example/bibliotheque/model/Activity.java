package org.example.bibliotheque.model;

import java.util.Date;

public class Activity {
    private String id;
    private String name;
    private int duration;
    private Date date;
    private int RPE;
    private int load;

    public Activity(String id, String name, int duration, Date date, int RPE, int load) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.RPE = RPE;
        this.load = load;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", RPE=" + RPE +
                ", load=" + load +
                '}';
    }
}
