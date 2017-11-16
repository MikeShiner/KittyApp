package com.kittyapp.rest.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemMessageContent
{
    private String description;
    private String type;
    private String location;
    private Date timestamp;
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
        @NotNull @JsonProperty("type") String type,
        @NotNull @JsonProperty("location") String location,
        @NotNull @JsonProperty("cost") double cost,
        @NotNull @JsonProperty("timestamp") Date timestamp)
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
    public Date getTimestamp()
    {
        return this.timestamp;
    }


    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp)
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
