package org.example.bibliotheque.controller;

import org.example.bibliotheque.model.Activity;
import org.example.bibliotheque.repository.ActivityRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.List;
import java.util.Optional;

public class ActivityControllerImpl implements ActivityController {
    ActivityRepository activityRepository;

    public ActivityControllerImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public String saveActivity(Activity activity) {
        return this.activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return this.activityRepository.findAll();
    }

    @Override
    public Optional<Activity> getActivity(String id) {
        return this.activityRepository.findOne(id);
    }

    @Override
    public UpdateResult updateActivity(String id, Activity activity) {
        return this.activityRepository.update(id, activity);
    }

    @Override
    public DeleteResult deleteActivity(String id) {
        return this.activityRepository.delete(id);
    }
}
