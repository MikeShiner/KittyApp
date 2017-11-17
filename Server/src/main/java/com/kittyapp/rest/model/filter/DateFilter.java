package com.kittyapp.rest.model.filter;

public class DateFilter
{
    private int month;
    private int year;

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
}
