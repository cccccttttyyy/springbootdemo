package com.tsrain.learning.job.dao;

import com.tsrain.learning.job.domain.Author;
import com.tsrain.learning.job.domain.MGAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MGAuthorDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void add(MGAuthor author) {
        this.mongoTemplate.insert(author);
    }
    public void update(MGAuthor author) {
        this.mongoTemplate.save(author);
    }
    public void delete(Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        this.mongoTemplate.remove(query, Author.class);
    }
    public MGAuthor findAuthor(Long id) {
        return this.mongoTemplate.findById(id, MGAuthor.class);
    }
    public List<MGAuthor> findAuthorList() {
        Query query = new Query();
        return this.mongoTemplate.find(query, MGAuthor.class);
    }
}