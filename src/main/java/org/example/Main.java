package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.bibliotheque.model.Activity;
import org.example.bibliotheque.model.Athlete;
import org.example.bibliotheque.repository.ActivityRepository;
import org.example.bibliotheque.repository.ActivityRepositoryImpl;
import org.example.bibliotheque.repository.AthleteRepository;
import org.example.bibliotheque.repository.AthleteRepositoryImpl;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (MongoClient mongoClient = Connection.getMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase("test"); // change "test" to your database name

            // create collections
            MongoCollection<Document> athleteCollection = database.getCollection("athletes");
            MongoCollection<Document> activityCollection = database.getCollection("activities");

            // create repositories
            AthleteRepository athleteRepository = new AthleteRepositoryImpl(athleteCollection);
            ActivityRepository activityRepository = new ActivityRepositoryImpl(activityCollection);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to 'create' or 'read' data?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("create")) {
                // create an athlete
                Athlete athlete = new Athlete("firstName", "lastName", new Date(), "male");
                athleteRepository.save(athlete);

                // create an activity
                Activity activity = new Activity("Running", 30, new Date(), 5, 150);
                activityRepository.save(activity);
            } else if (action.equalsIgnoreCase("read")) {
                // Read all activities
                System.out.println(activityRepository.findAll());
            } else {
                System.out.println("Invalid action. Please type 'create' or 'read'.");
            }
        }
    }
}
