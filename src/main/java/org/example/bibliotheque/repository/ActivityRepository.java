package org.example.bibliotheque.repository;

import com.mongodb.client.result.InsertOneResult;
import org.example.bibliotheque.model.Activity;

public interface ActivityRepository {
    InsertOneResult save(Activity activity);
}
