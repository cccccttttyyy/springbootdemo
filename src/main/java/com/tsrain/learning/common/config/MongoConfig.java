package com.tsrain.learning.common.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@PropertySource("classpath:config/mongodb.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String mongoHost ;
    @Value("${mongo.port}")
    private int mongoPort;
    @Value("${mongo.defaultDbName}")
    private String dbName;
    @Value("${mongo.user}")
    private String username;
    @Value("${mongo.pwd}")
    private String password;

    private static final String MONGO_BASE_PACKAGE = "com.tsrain.learning.job.domain";

    @Autowired
    private ApplicationContext appContext;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
        return mongoClient;
    }

    @Override
    protected String getMappingBasePackage() {
        return MONGO_BASE_PACKAGE;
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        UserCredentials userCredentials = new UserCredentials(username,password);
        return new MongoTemplate(mongo(), getDatabaseName(),userCredentials);
    }
}
