package org.example.bibliotheque.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.example.bibliotheque.model.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityController {
    String saveActivity(Activity activity);
    List<Activity> getAllActivities();
    Optional<Activity> getActivity(String id);
    UpdateResult updateActivity(String id, Activity activity);
    DeleteResult deleteActivity(String id);
}
