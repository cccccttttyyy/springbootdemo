package com.tsrain.learning.job.service;

import com.tsrain.learning.job.dao.MBAuthorMapper;
import com.tsrain.learning.job.domain.MBAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MBAuthorService {
    @Autowired
    private MBAuthorMapper authorMapper;

    public int add(String realName, String nickName) {
        return this.authorMapper.add(realName, nickName);
    }

    public int update(String realName, String nickName, Long id) {
        return this.authorMapper.update(realName, nickName, id);
    }

    public int delete(Long id) {
        return this.authorMapper.delete(id);
    }

    public MBAuthor findAuthor(Long id) {
        return this.authorMapper.findAuthor(id);
    }

    public List<MBAuthor> findAuthorList() {
        return this.authorMapper.findAuthorList();
    }
}