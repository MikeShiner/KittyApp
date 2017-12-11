package com.kittyapp.dataaccess.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.TransactionFilter;

public interface TransactionDao
{
    Transaction addTransaction(Transaction trans);

    List<Transaction> getTransactions(TransactionFilter filter, Pageable page);
    
    List<Transaction> getAllTransaction();
    
    double getRunningTotal(TransactionFilter filter);

    void deleteTransaction(String transactionId);
    
    Transaction updateTransaction(String transactionId, Transaction updateTrans);
}
