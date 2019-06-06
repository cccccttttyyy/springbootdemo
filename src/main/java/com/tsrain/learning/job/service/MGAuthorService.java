package com.tsrain.learning.job.service;

import com.tsrain.learning.job.dao.AuthorDao;
import com.tsrain.learning.job.dao.MGAuthorDao;
import com.tsrain.learning.job.domain.Author;
import com.tsrain.learning.job.domain.MGAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MGAuthorService {
    @Autowired
    private MGAuthorDao authorDao;

    public void add(MGAuthor author) {
        this.authorDao.add(author);
    }
    public void update(MGAuthor author) {
        this.authorDao.update(author);
    }
    public void delete(Long id) {
        this.authorDao.delete(id);
    }
    public MGAuthor findAuthor(Long id) {
        return this.authorDao.findAuthor(id);
    }
    public List<MGAuthor> findAuthorList() {
        return this.authorDao.findAuthorList();
    }
}