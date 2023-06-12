package org.example.bibliotheque.repository;

import com.mongodb.client.result.InsertOneResult;
import org.example.bibliotheque.model.athlete;

public interface AthleteRepository {
    InsertOneResult save(athlete athlete);
}
