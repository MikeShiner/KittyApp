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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(fundsLeft);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((lastTransactions_5 == null) ? 0 : lastTransactions_5.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Dashboard other = (Dashboard) obj;
        if (Double.doubleToLongBits(fundsLeft) != Double.doubleToLongBits(other.fundsLeft)) return false;
        if (lastTransactions_5 == null)
        {
            if (other.lastTransactions_5 != null) return false;
        }
        else if (!lastTransactions_5.equals(other.lastTransactions_5)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Dashboard [lastTransactions_5=" + lastTransactions_5 + ", fundsLeft=" + fundsLeft + "]";
    }	
}
