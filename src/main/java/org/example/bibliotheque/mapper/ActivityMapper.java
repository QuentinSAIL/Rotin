package org.example.bibliotheque.mapper;

import org.bson.Document;
import org.example.bibliotheque.model.Activity;

import java.util.Date;

public class ActivityMapper {
    public static Document activityToDocument(Activity activity) {
        return new Document()
                .append("_id", activity.getId())
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("date", activity.getDate())
                .append("RPE", activity.getRPE())
                .append("load", activity.getLoad());
    }

    public static Activity documentToActivity(Document document) {
        String id = document.getString("_id");
        String name = document.getString("name");
        int duration = document.getInteger("duration");
        Date date = document.getDate("date");
        int RPE = document.getInteger("RPE");
        int load = document.getInteger("load");

        return new Activity(id, name, duration, date, RPE, load);
    }
}