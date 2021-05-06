package edu.feng.trend.service;

import edu.feng.trend.pojo.Index;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-11 09:15
 * @version: 1.0
 */
//
@Service
@CacheConfig(cacheNames = "indexes")
public class IndexService {
    private List<Index> indexes;

    @Cacheable(key = "'all_codes'")
    public List<Index> get() {
        Index index = new Index();
        index.setCode("000000");
        index.setName("无效指数代码");
        return indexes;
    }
}