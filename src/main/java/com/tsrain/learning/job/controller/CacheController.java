package com.tsrain.learning.job.controller;

import com.tsrain.learning.job.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("concurrentmapcache.cacheController")
@RequestMapping(value = "/concurrentmapcache/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    /**
     * 查询方法
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getByCache() {
        Long startTime = System.currentTimeMillis();
        long timestamp = this.cacheService.getByCache();
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        return timestamp+"";
    }

    /**
     * 保存方法
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void save() {
        this.cacheService.save();
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void delete() {
        this.cacheService.delete();
    }
}