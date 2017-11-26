package com.kittyapp.configuration;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class MongoDbConfiguration
{
    @Bean
    public CustomConversions customConversions()
    {
        List<Converter<?, ?>> converters = new ArrayList<>();
        
        converters.add(new DateToZonedDateTimeConverter());
        converters.add(new ZonedDateTimeToDateConverter());
        converters.addAll(Jsr310Converters.getConvertersToRegister());
        
        return new CustomConversions(converters);
    }
    
    public static class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date>
    {
        public Date convert(ZonedDateTime source)
        {
            return Date.from(source.withZoneSameInstant(ZoneOffset.UTC.normalized()).toInstant());
        }
    }

    public static class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime>
    {
        public ZonedDateTime convert(Date source)
        {
            if (source == null)
            {
                return null;
            }
            return ZonedDateTime.ofInstant(source.toInstant(), ZoneOffset.UTC.normalized());
        }
    }
}
