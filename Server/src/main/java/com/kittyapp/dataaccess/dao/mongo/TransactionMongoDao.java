package com.kittyapp.dataaccess.dao.mongo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.kittyapp.dataaccess.dao.TransactionDao;
import com.kittyapp.dataaccess.entities.Transaction;
import com.kittyapp.rest.model.filter.TransactionFilter;
import com.mongodb.BasicDBObject;

@Component
public class TransactionMongoDao implements TransactionDao
{

    @Autowired
    private MongoOperations mongoOps;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionMongoDao.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaction addTransaction(Transaction trans)
    {
        this.mongoOps.save(trans, Transaction.COLLECTION_NAME);
        return trans;
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> getTransactions(TransactionFilter filter, Pageable paging)
    {
        List<AggregationOperation> ops = new ArrayList<>();
        // TODO need to separate this out in to a different aggregation class
        if (paging != null)
        {
            if (paging.getSort() != null)
            {
                ops.add(sort(paging.getSort()));
            }
            ops.add(skip((long) paging.getOffset()));
            ops.add(limit(paging.getPageSize()));
        }

        ops.add(match(getFilterCriteria(filter)));

        ops.add(Aggregation.sort(Sort.Direction.DESC, Transaction.FIELD_TIMESTAMP));
        if (filter.getQty() != 0)
        {
            ops.add(limit(filter.getQty()));
        }

        TypedAggregation<?> aggr = Aggregation.newAggregation(Transaction.class, ops);

        return this.mongoOps.aggregate(
            aggr, Transaction.COLLECTION_NAME, Transaction.class)            
            .getMappedResults();
    }

    /**
     * @param filter
     * @return
     */
    @Override
    public double getRunningTotal(TransactionFilter filter)
    {
        List<AggregationOperation> ops = new ArrayList<>();
        ops.add(match(getFilterCriteria(filter)));
        ops.add(Aggregation.group().sum("cost").as("total"));

        
        TypedAggregation<?> aggr = Aggregation.newAggregation(Transaction.class, ops);
        AggregationResults<BasicDBObject> aggregationResults = this.mongoOps.aggregate(
            aggr, Transaction.COLLECTION_NAME, BasicDBObject.class);
        try {
            return aggregationResults.getUniqueMappedResult().getDouble("total");
        } catch (Exception ex) {
            return 0.0;
        }
    }

    @Override
    public void deleteTransaction(String transactionId) {
        LOGGER.info("Removing Transaction {}", transactionId);
        Query q = new Query(Criteria.where("_id").is(new ObjectId(transactionId)));
        mongoOps.remove(q, Transaction.class, Transaction.COLLECTION_NAME);
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> getAllTransaction()
    {
        List<Transaction> transactionList = this.mongoOps.findAll(Transaction.class, Transaction.COLLECTION_NAME);
        return transactionList;
    }

    private static CriteriaDefinition getFilterCriteria(TransactionFilter filter)
    {
    	Criteria dateCriteria = new Criteria();
        List<Criteria> criteriaList = new ArrayList<>();

        if (filter.getMonth() > 0 && filter.getYear() > 0)
        {
            LocalDate startRange = LocalDate.of(filter.getYear(), filter.getMonth(), 1);
            LocalDate endRange = startRange.withDayOfMonth(startRange.lengthOfMonth());
            dateCriteria = new Criteria().andOperator(
                where(Transaction.FIELD_TIMESTAMP).gt(startRange),
                where(Transaction.FIELD_TIMESTAMP).lte(endRange));
            criteriaList.add(dateCriteria);
        }

//        return new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()]));
        
        // mLab has restrictions using and operators for empty arrays. Since we only have one criteria,
        // we have to return the criteria directly.
        return dateCriteria;
    }

}
