package org.example.bibliotheque.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.bibliotheque.mapper.ActivityMapper;
import org.example.bibliotheque.model.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;
import static org.example.bibliotheque.mapper.ActivityMapper.activityToDocument;
import static org.example.bibliotheque.mapper.ActivityMapper.documentToActivity;

public class ActivityRepositoryImpl implements ActivityRepository{
    MongoCollection<Document> collection;

    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }

    @Override
    public String save(Activity activity) {
        InsertOneResult result = this.collection.insertOne(activityToDocument(activity));
        return result.getInsertedId().asString().getValue();
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

    @Override
    public Optional<Activity> findOne(String id) {
        Document doc = collection.find(eq("_id", new ObjectId(id))).first();
        return Optional.ofNullable(doc).map(ActivityMapper::documentToActivity);
    }

    @Override
    public UpdateResult update(String id, Activity activity) {
        UpdateResult result = collection.replaceOne(eq("_id", new ObjectId(id)), activityToDocument(activity));
        return result;
    }

    @Override
    public DeleteResult delete(String id) {
        DeleteResult result = collection.deleteOne(eq("_id", new ObjectId(id)));
        return result;
    }

}
