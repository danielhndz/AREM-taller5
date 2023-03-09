package edu.escuelaing.arem.persistence;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static final String URL_STRING = "ec2-xx-xxx-xxx-xx.compute-1.amazonaws.com";
    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public MongoConnection() throws UnknownHostException {
        mongoClient = new MongoClient(URL_STRING, 27017);
        db = mongoClient.getDatabase("arem");
        collection = db.getCollection("logs");
    }

    public void add(String message, Date date) {
        Document document = new Document();
        document.put("message", message);
        document.put("date", date);
        collection.insertOne(document);
    }

    public ArrayList<Document> consult() {
        ArrayList<Document> records = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().cursor();
        while (cursor.hasNext()) {
            records.add(cursor.next());
        }
        return records;
    }
}
