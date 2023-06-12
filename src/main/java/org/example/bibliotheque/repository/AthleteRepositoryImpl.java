package org.example.bibliotheque.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.example.bibliotheque.model.athlete;

import static org.example.bibliotheque.mapper.AthleteMapper.athleteToDocument;

public class AthleteRepositoryImpl implements AthleteRepository{
    MongoCollection<Document> collection;

    public AthleteRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }

    @Override
    public InsertOneResult save(athlete athlete) {
        return this.collection.insertOne(athleteToDocument(athlete));
    }
}