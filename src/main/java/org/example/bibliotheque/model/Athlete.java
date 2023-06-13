package org.example.bibliotheque.model;

import java.util.Date;

public class Athlete {
    private String firstName;
    private String name;
    private Date birthday;
    private String sex;

    public Athlete(String firstName, String name, Date birthday, String sex) {
        this.firstName = firstName;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}