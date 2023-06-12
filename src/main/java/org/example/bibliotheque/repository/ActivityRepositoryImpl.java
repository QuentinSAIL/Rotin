package org.example.bibliotheque.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.example.bibliotheque.model.Activity;

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
}