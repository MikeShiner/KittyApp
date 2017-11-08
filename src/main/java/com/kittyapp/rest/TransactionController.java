package com.kittyapp.rest;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kittyapp.rest.model.SystemMessageContent;

@RestController
@RequestMapping("/transactions")
public class TransactionController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(
        path = "/add",
        method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTransaction(
        @RequestBody @Valid SystemMessageContent newTransactionContent) throws Exception
    {
        LOGGER.info("New transaciton received. {}", newTransactionContent.toString());
        return new ResponseEntity<>(newTransactionContent, HttpStatus.OK);
    }
}
