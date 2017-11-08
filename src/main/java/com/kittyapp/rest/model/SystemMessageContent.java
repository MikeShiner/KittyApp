package com.kittyapp.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemMessageContent
{
    private String description;
    private String type;
    private String location;
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
        @JsonProperty("cost") double cost)
    {
        this.description = description;
        this.type = type;
        this.location = location;
        this.cost = cost;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * @return the location
     */
    public String getLocation()
    {
        return this.location;
    }

    /**
     * @return the cost
     */
    public double getCost()
    {
        return this.cost;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "SystemMessageContent [description="
            + description + ", type=" + type + ", location=" + location + ", cost=" + cost + "]";
    }      
    
}
