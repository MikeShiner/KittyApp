package com.kittyapp.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kittyapp.configuration.AppConfiguration;
import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Dashboard;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.TransactionFilter;

@RestController
@RequestMapping("/dashboard")
public class DashboardController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
    
	@Autowired private TransactionDao transactionDao;
	@Autowired private AppConfiguration AppConfig;
	
    @RequestMapping(method = RequestMethod.GET)
    public Dashboard getDashboard(TransactionFilter filter)
    {
        return getDashboardData(filter);
    }
    
    private Dashboard getDashboardData(TransactionFilter filter)
    {    	
        double monthInitial = AppConfig.getMonthlyInitial();
        LOGGER.info("" + monthInitial);
        
        filter.setQty(5);
    	List<Transaction> lastTransactions_5 = transactionDao.getTransactions(filter, null);
    	double runningTotal = transactionDao.getRunningTotal(filter);
    	
    	Dashboard dash = new Dashboard(lastTransactions_5, (monthInitial - runningTotal));
    	return dash;
    }

}
