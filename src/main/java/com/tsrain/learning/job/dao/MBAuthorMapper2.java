package com.tsrain.learning.job.dao;

import com.tsrain.learning.job.domain.Author;
import com.tsrain.learning.job.domain.MBAuthor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MBAuthorMapper2 {
    MBAuthor findAuthor(@Param("id") Long id);
}
