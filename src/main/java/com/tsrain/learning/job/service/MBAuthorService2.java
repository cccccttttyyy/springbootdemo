package com.tsrain.learning.job.service;

import com.tsrain.learning.job.dao.MBAuthorMapper2;
import com.tsrain.learning.job.domain.Author;
import com.tsrain.learning.job.domain.MBAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MBAuthorService2 {
    @Autowired
    private MBAuthorMapper2 authorMapper2;

    public MBAuthor findAuthor(Long id) {
        return this.authorMapper2.findAuthor(id);
    }
}