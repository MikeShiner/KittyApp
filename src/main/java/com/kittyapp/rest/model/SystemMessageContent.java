package com.kittyapp.rest.model;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemMessageContent
{
    private String description;
    private String type;
    private String location;
    private ZonedDateTime timestamp;
    private double cost;
    
    /**
     * Constructor for creating a new instance of {@link SystemMessageContent}
     * @param description
     * @param type
     * @param location
     * @param cost
     */
    public SystemMessageContent(
        @JsonProperty("description") String description, 
        @JsonProperty("type") String type, 
        @JsonProperty("location") String location, 
        @JsonProperty("cost") double cost,
        @JsonProperty("timestamp") ZonedDateTime timestamp)
    {
        this.description = description;
        this.type = type;
        this.location = location;
        this.cost = cost;
        this.timestamp = timestamp;
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
     * @return
     */
    @Override
    public String toString()
    {
        return "SystemMessageContent [description="
            + description + ", type=" + type + ", location=" + location + ", timestamp=" + timestamp + ", cost=" + cost
            + "]";
    }
}
