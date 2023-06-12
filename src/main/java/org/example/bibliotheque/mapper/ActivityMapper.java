package org.example.bibliotheque.mapper;

import org.bson.Document;
import org.example.bibliotheque.model.Activity;

public class ActivityMapper {
    public static Document activityToDocument(Activity activity) {
        return new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("date", activity.getDate())
                .append("RPE", activity.getRPE())
                .append("load", activity.getLoad());
    }
}
