package com.tsrain.learning;

import com.tsrain.learning.job.dao.RedisBaseDao;
import com.tsrain.learning.job.domain.MGAuthor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTest {

    @Resource(name="oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;
    @Resource(name="twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void test() {
        jdbcTemplate1.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 4, "梁桂钊", "LiangGzone");
        jdbcTemplate2.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 5, "梁桂钊", "LiangGzone");
    }

    @Autowired
    RedisBaseDao redisBaseDao;

    @Test
    public void test1() {
        this.redisBaseDao.addValue("main","haha");
        System.out.println("value: "+this.redisBaseDao.getValue("main"));
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongo(){
        MGAuthor mg= new MGAuthor();
        mg.setId(Long.valueOf(1));
        mg.setRealName("mongo");
        mg.setNickName("fakermon");
        mongoTemplate.insert(mg);
    }
}