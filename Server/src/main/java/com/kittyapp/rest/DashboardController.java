package com.kittyapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Dashboard;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.DateFilter;

@RestController
public class DashboardController
{
	@Autowired
	private TransactionDao transactionDao;
	
	@Value("${monthly.spend.total}")
	private double MONTH_TOTAL;
	
    @RequestMapping(path = "/dashbord", method = RequestMethod.GET)
    public Dashboard getDashboard(DateFilter filter)
    {
        return getDashboardData(filter);
    }
    
    private Dashboard getDashboardData(DateFilter filter)
    {    	
    	List<Transaction> lastTransactions_5 = transactionDao.getTransactions(filter, null);
    	return new Dashboard(lastTransactions_5, this.MONTH_TOTAL);    	
    }

}
