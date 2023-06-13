package org.example.bibliotheque.mapper;

import org.bson.Document;
import org.example.bibliotheque.model.Athlete;

public class AthleteMapper {
    public static Document athleteToDocument(Athlete athlete) {
        return new Document()
                .append("firstName", athlete.getFirstName())
                .append("name", athlete.getName())
                .append("birthday", athlete.getBirthday())
                .append("sex", athlete.getSex())
                ;
    }
}