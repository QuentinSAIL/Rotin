package org.example.bibliotheque.repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.example.bibliotheque.model.Activity;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository {
    String save(Activity activity);
    List<Activity> findAll();
    Optional<Activity> findOne(String id);
    UpdateResult update(String id, Activity activity);
    DeleteResult delete(String id);
}
