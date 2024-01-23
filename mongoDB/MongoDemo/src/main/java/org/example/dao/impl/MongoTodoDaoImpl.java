package org.example.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class MongoTodoDaoImpl implements TodoDao {

    private MongoCollection<Document> collection;

    public MongoTodoDaoImpl(MongoDatabase mongoDatabase) {

        collection = mongoDatabase.getCollection("todos");
    }

    @Override
    public void addTodo(TodoItem todoitem) {
        Document doc = new Document("title", todoitem.getTitle())
                .append("description", todoitem.getDescription())
                .append("completed", todoitem.isCompleted());
        collection.insertOne(doc);
    }

    @Override
    public List<TodoItem> getAllTodos() {
        List<TodoItem> todos = new ArrayList<>();
        for (Document doc: collection.find()
             ) {
            todos.
        }
        return null;
    }


}
