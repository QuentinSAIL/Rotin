package org.example;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connection {

    private static final Logger logger = LoggerFactory.getLogger(Connection.class);

    public static MongoClient getMongoClient() {
        String connectionString = "mongodb+srv://quentin:sGs2gYdZB2811RDw@cluster0.cjvhqit.mongodb.net/?retryWrites=true&w=majority";

        MongoClient mongoClient;
        try {
            mongoClient = MongoClients.create(connectionString);
        } catch (MongoException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to MongoDB", e);
        }

        return mongoClient;
    }
}