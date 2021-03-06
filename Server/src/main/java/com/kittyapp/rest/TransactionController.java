package com.kittyapp.rest;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.SystemMessageContent;
import com.kittyapp.rest.model.filter.TransactionFilter;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    private final Clock clock = Clock.systemUTC();

    @Autowired
    private TransactionDao transactionDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Transaction> getTransactions(TransactionFilter filter, Pageable paging)
    {
        return this.transactionDao.getTransactions(filter, paging);
    }
    
    @RequestMapping(
        path = "/add", 
        method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTransaction(
        @RequestBody @Valid SystemMessageContent newTransContent) throws Exception
    {
        LOGGER.info("New transaciton received. {}", newTransContent.toString());
        Transaction newTransaction = new Transaction(newTransContent.getDescription(),
            newTransContent.getType(), newTransContent.getLocation(), newTransContent.getCost(),
            newTransContent.getTimestamp(), ZonedDateTime.now(this.clock));

        transactionDao.addTransaction(newTransaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/{transactionId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTransaction(
            @PathVariable("transactionId")String transactionId)
    {
        LOGGER.info("Request to delete transaction {}", transactionId);

        transactionDao.deleteTransaction(transactionId);

        return new ResponseEntity<>(transactionId, HttpStatus.OK);
    }
    
    @RequestMapping(
        path = "/{transactionId}", 
        method = RequestMethod.PUT, 
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTransaction(
        @PathVariable("transactionId")String transactionId,
        @RequestBody @Valid SystemMessageContent newTransContent) throws Exception
    {
        LOGGER.info("Request to update existing transaciton received. {}", newTransContent.toString());
        Transaction updatedTransaction = new Transaction(newTransContent.getDescription(),
            newTransContent.getType(), newTransContent.getLocation(), newTransContent.getCost(),
            newTransContent.getTimestamp(), ZonedDateTime.now(this.clock));

        transactionDao.updateTransaction(transactionId, updatedTransaction);

        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

}
