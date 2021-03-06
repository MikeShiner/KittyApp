package com.kittyapp.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kittyapp.configuration.AppConfiguration;
import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Dashboard;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.TransactionFilter;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
    
	@Autowired private TransactionDao transactionDao;
	@Autowired private AppConfiguration AppConfig;
	
    @RequestMapping(method = RequestMethod.GET)
    public Dashboard getDashboard(TransactionFilter filter)
    {
        Dashboard dash = getDashboardData(filter);
        LOGGER.info("Dashboard Request: {}", dash);
        return dash;
    }
    
    private Dashboard getDashboardData(TransactionFilter filter)
    {    	 
        filter.setQty(5);
    	List<Transaction> lastTransactions_5 = transactionDao.getTransactions(filter, null);
    	double runningTotal = transactionDao.getRunningTotal(filter);
    	double fundsRemaining = AppConfig.getMonthlyInitial() - runningTotal;

    	return new Dashboard(lastTransactions_5, fundsRemaining);
    }

}
