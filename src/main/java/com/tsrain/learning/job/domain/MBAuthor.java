package com.tsrain.learning.job.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class MBAuthor {
    private Long id;
    @JSONField(name="real_name")
    private String realName;
    @JSONField(name="nick_name")
    private String nickName;

    // SET和GET方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}