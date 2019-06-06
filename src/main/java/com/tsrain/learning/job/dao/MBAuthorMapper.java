package com.tsrain.learning.job.dao;

import com.tsrain.learning.job.domain.MBAuthor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MBAuthorMapper {

    @Insert("insert into mb_author(real_name, nick_name) values(#{real_name}, #{nick_name})")
    int add(@Param("realName") String realName, @Param("nickName") String nickName);

    @Update("update mb_author set real_name = #{real_name}, nick_name = #{nick_name} where id = #{id}")
    int update(@Param("real_name") String realName, @Param("nick_name") String nickName, @Param("id") Long id);

    @Delete("delete from mb_author where id = #{id}")
    int delete(Long id);

    @Select("select id, real_name as realName, nick_name as nickName from mb_author where id = #{id}")
    MBAuthor findAuthor(@Param("id") Long id);

    @Select("select id, real_name as realName, nick_name as nickName from mb_author")
    List<MBAuthor> findAuthorList();
}
