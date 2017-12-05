package com.kittyapp.dataaccess.dao.mongo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import com.kittyapp.dataaccess.dao.DetailsDao;
import com.kittyapp.dataaccess.entities.Transaction;

@Component
public class DetailsMongoDao implements DetailsDao
{
    @Autowired
    private MongoOperations mongoOps;

    /**
     * @return Returns unique list of locations
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getLocations()
    {      
        return this.mongoOps.getCollection(Transaction.COLLECTION_NAME)
            .distinct(Transaction.FIELD_LOCATION);
    }
    
    /**
     * @return Returns unique list of locations
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getTypes()
    {
        return this.mongoOps.getCollection(Transaction.COLLECTION_NAME)
            .distinct(Transaction.FIELD_TYPE);
    }

}
