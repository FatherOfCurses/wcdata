package com.principe.wcdata.daos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao extends AbstractDao {

    public String TRANSACTION_COLLECTION = "transaction";
    private final MongoCollection<Document> transactionCollection;

    protected TransactionDao(MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        transactionCollection = db.getCollection(TRANSACTION_COLLECTION);
    }

    public static TransactionDao create(MongoClient mongoClient, String databaseName) {
        return new TransactionDao(mongoClient, databaseName);
    }
}
