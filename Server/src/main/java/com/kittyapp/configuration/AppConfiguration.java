package com.kittyapp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kittyapp")
public class AppConfiguration
{
    double monthlyInitial;

    /**
     * @return the monthlyInitial
     */
    public double getMonthlyInitial()
    {
        return this.monthlyInitial;
    }

    /**
     * @param monthlyInitial the monthlyInitial to set
     */
    public void setMonthlyInitial(double monthlyInitial)
    {
        this.monthlyInitial = monthlyInitial;
    }
}
