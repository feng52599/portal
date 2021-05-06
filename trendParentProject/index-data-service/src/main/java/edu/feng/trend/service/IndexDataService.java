package edu.feng.trend.service;

import cn.hutool.core.collection.CollUtil;
import edu.feng.trend.pojo.IndexData;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "index_datas")
public class IndexDataService {

    @Cacheable(key = "'indexData-code-'+ #p0")
    public List<IndexData> get(String code) {
        return CollUtil.toList();
    }
}