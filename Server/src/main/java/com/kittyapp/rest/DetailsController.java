package com.kittyapp.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kittyapp.dataaccess.dao.DetailsDao;


@RestController
@CrossOrigin
@RequestMapping("/details")
public class DetailsController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailsController.class);
    @Autowired private DetailsDao detailsDao;
    
    @RequestMapping(
        path = "/location",
        method = RequestMethod.GET, 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getLocations() throws Exception
    {
        LOGGER.info("Getting list of locations.");       
        
        return detailsDao.getLocations();
    }
}
