package com.tsrain.learning.job.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsrain.learning.job.domain.MGAuthor;
import com.tsrain.learning.job.service.MGAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/data/mongodb/author")
public class MGAuthorController {
    @Autowired
    private MGAuthorService MGAuthorService;
    /**
     * 查询用户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getMGAuthorList(HttpServletRequest request) {
        List<MGAuthor> MGAuthorList = this.MGAuthorService.findAuthorList();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("total", MGAuthorList.size());
        param.put("rows", MGAuthorList);
        return param;
    }
    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public MGAuthor getMGAuthor(@PathVariable Long userId, HttpServletRequest request) {
        MGAuthor MGAuthor = this.MGAuthorService.findAuthor(userId);
        if(MGAuthor == null){
            throw new RuntimeException("查询错误");
        }
        return MGAuthor;
    }
    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("user_id");
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");
        MGAuthor MGAuthor = new MGAuthor();
        if (MGAuthor!=null) {
            MGAuthor.setId(Long.valueOf(userId));
        }
        MGAuthor.setRealName(realName);
        MGAuthor.setNickName(nickName);
        try{
            this.MGAuthorService.add(MGAuthor);
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
        MGAuthor MGAuthor = this.MGAuthorService.findAuthor(userId);
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");
        MGAuthor.setRealName(realName);
        MGAuthor.setNickName(nickName);
        try{
            this.MGAuthorService.update(MGAuthor);
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
            this.MGAuthorService.delete(userId);
        }catch(Exception e){
            throw new RuntimeException("删除错误");
        }
    }
}
