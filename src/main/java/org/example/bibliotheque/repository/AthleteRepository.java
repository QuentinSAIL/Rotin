package org.example.bibliotheque.repository;

import com.mongodb.client.result.InsertOneResult;
import org.example.bibliotheque.model.Athlete;

public interface AthleteRepository {
    InsertOneResult save(Athlete athlete);
}
