package br.com.scorpion.poc.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDbConnection {

    private static MongoDbConnection ourInstance = new MongoDbConnection();
    private MongoDatabase database;


    public static MongoDbConnection getInstance() {
        return ourInstance;
    }

    private MongoDbConnection() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);

        database = mongoClient.getDatabase("mydb");

    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
