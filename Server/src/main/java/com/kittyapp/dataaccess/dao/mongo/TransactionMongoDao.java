package com.kittyapp.dataaccess.dao.mongo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Transaction;

@Component
public class TransactionMongoDao implements TransactionDao
{

    @Autowired
    private MongoOperations mongoOps;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Transaction addTransaction(Transaction trans)
    {
        this.mongoOps.save(trans, Transaction.COLLECTION_NAME);
        return trans;
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> getAllTransaction()
    {
        List<Transaction> transactionList = this.mongoOps.findAll(Transaction.class, Transaction.COLLECTION_NAME);
        return transactionList;
    }
}
