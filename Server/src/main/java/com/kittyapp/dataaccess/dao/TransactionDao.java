package com.kittyapp.dataaccess.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.DateFilter;

public interface TransactionDao
{
    Transaction addTransaction(Transaction trans);

    List<Transaction> getTransactions(DateFilter filter, Pageable page);
    
    List<Transaction> getAllTransaction();
    
}
