package com.kittyapp.dataaccess.dao;

import java.util.List;
import com.kittyapp.dataaccess.entities.Transaction;

public interface TransactionDao
{
    Transaction addTransaction(Transaction trans);
    
    List<Transaction> getAllTransaction();
}
