package org.example;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try{
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        }catch(IOException e){
            System.out.println("Pas de fichier");
        }

        String dbName = properties.getProperty("mongo.database.name");
        String host = properties.getProperty("mongo.host");
        String port = properties.getProperty("mongo.port");

        ConnectionString connectionString = new ConnectionString("mongodb://"+ host + port + ":" + port);

        MongoClientSettings connString = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        try(MongoClient mongoClient = MongoClients.create(connString)){

            MongoDatabase database = mongoClient.getDatabase(dbName);
        }

    }
}