package com.kittyapp.dataaccess.entities;

import java.time.ZonedDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Transaction
{
    public static final String COLLECTION_NAME = "Transaction";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_LOCATION = "location";
    public static final String FIELD_COST = "cost";
    public static final String FIELD_TIMESTAMP = "Timestamp";
    public static final String FIELD_CREATED = "createdTimestamp";
    
    @Id
    private String transactionId;
    private String description;
    private String type;
    private String location;
    private double cost;
    private ZonedDateTime timestamp;
    private ZonedDateTime createdTimestamp;
    /**
     * Constructor for creating a new instance of {@link Transaction}
     * @param description
     * @param type
     * @param location
     * @param cost
     * @param timestamp
     * @param createdTimestamp
     */
    @PersistenceConstructor
    public Transaction(
        String description, String type, String location, double cost, ZonedDateTime timestamp,
        ZonedDateTime createdTimestamp)
    {
        this.description = description;
        this.type = type;
        this.location = location;
        this.cost = cost;
        this.timestamp = timestamp;
        this.createdTimestamp = createdTimestamp;
    }
    
    /**
     * @return the transactionId
     */
    public String getTransactionId()
    {
        return this.transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * @return the type
     */
    public String getType()
    {
        return this.type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }
    /**
     * @return the location
     */
    public String getLocation()
    {
        return this.location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    /**
     * @return the cost
     */
    public double getCost()
    {
        return this.cost;
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    /**
     * @return the timestamp
     */
    public ZonedDateTime getTimestamp()
    {
        return this.timestamp;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(ZonedDateTime timestamp)
    {
        this.timestamp = timestamp;
    }
    /**
     * @return the createdTimestamp
     */
    public ZonedDateTime getCreatedTimestamp()
    {
        return this.createdTimestamp;
    }
    /**
     * @param createdTimestamp the createdTimestamp to set
     */
    public void setCreatedTimestamp(ZonedDateTime createdTimestamp)
    {
        this.createdTimestamp = createdTimestamp;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "Transaction [description="
            + description + ", type=" + type + ", location=" + location + ", cost=" + cost + ", timestamp=" + timestamp
            + ", createdTimestamp=" + createdTimestamp + "]";
    }   
}
