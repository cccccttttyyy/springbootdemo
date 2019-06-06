package com.tsrain.learning.job.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsrain.learning.job.domain.MBAuthor;
import com.tsrain.learning.job.service.MBAuthorService;
import com.tsrain.learning.job.service.MBAuthorService2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("mybatis.authorController")
@RequestMapping(value="/data/mybatis/author")
public class MBAuthorController {

    @Autowired
    private MBAuthorService authorService;

    @Autowired
    private MBAuthorService2 authorService2;
    /**
     * 查询用户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getAuthorList(HttpServletRequest request) {
        List<MBAuthor> authorList = this.authorService.findAuthorList();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }
    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public MBAuthor getAuthor(@PathVariable Long userId, HttpServletRequest request) {
        MBAuthor author = this.authorService2.findAuthor(userId);
        if(author == null){
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("user_id");
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");

        try{
            this.authorService.add(realName, nickName);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }
    /**
     * 更新方法
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId, @RequestBody JSONObject jsonObject) {
        MBAuthor author = this.authorService2.findAuthor(userId);
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");

        try{
            this.authorService.update(realName, nickName, author.getId());
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }
    /**
     * 删除方法
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        try{
            this.authorService.delete(userId);
        }catch(Exception e){
            throw new RuntimeException("删除错误");
        }
    }
}