package com.kittyapp.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;

public class Dashboard
{
    List<Transaction> lastTransactions_5;
    double fundsLeft;
    
	public Dashboard(List<Transaction> lastTransactions_5, double fundsLeft) {
		this.lastTransactions_5 = lastTransactions_5;
		this.fundsLeft = fundsLeft;
	}
	
	public List<Transaction> getLastTransactions_5() {
		return lastTransactions_5;
	}
	public void setLastTransactions_5(ArrayList<Transaction> lastTransactions_5) {
		this.lastTransactions_5 = lastTransactions_5;
	}
	public double getFundsLeft() {
		return fundsLeft;
	}
	public void setFundsLeft(double fundsLeft) {
		this.fundsLeft = fundsLeft;
	}
}
