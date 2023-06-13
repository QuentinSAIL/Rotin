package org.example.bibliotheque.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.example.bibliotheque.model.Activity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.bibliotheque.mapper.ActivityMapper.activityToDocument;

public class ActivityRepositoryImpl implements ActivityRepository{
    MongoCollection<Document> collection;

    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }

    @Override
    public InsertOneResult save(Activity activity) {
        return this.collection.insertOne(activityToDocument(activity));
    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activities = new ArrayList<>();
        for (Document document : collection.find()) {
            Activity activity = documentToActivity(document);
            activities.add(activity);
        }
        return activities;
    }

    private Activity documentToActivity(Document document) {
        String name = document.getString("name");
        int duration = document.getInteger("duration");
        Date date = document.getDate("date");
        int RPE = document.getInteger("RPE");
        int load = document.getInteger("load");

        return new Activity(name, duration, date, RPE, load);
    }
}