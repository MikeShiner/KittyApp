package com.kittyapp.rest.model.filter;

public class TransactionFilter
{
    private int month;
    private int year;
    private int qty;

    /**
     * @return the month
     */
    public int getMonth()
    {
        return this.month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month)
    {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * @return the qty
     */
    public int getQty()
    {
        return this.qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty)
    {
        this.qty = qty;
    }
}
