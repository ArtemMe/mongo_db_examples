package ru.artemme;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DomainRemositoryCustomImpl implements DomainRemositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updateDomain(String domain, boolean displayAds) {
        Query query = new Query(Criteria.where("domain").is(domain));
        Update update = new Update();

        update.set("displayAds", displayAds);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Domain.class);

        return result.getMatchedCount();
    }
}
