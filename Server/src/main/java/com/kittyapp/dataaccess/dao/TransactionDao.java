package com.kittyapp.dataaccess.dao;

import com.kittyapp.dataaccess.entities.Transaction;

public interface TransactionDao
{
    Transaction addTransaction(Transaction trans);
}
