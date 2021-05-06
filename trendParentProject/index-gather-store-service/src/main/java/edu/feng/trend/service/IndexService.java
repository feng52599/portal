package edu.feng.trend.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.feng.trend.pojo.Index;
import edu.feng.trend.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: trendParentProject
 * @description:
 * @author: feng
 * @create: 2020-05-10 21:06
 */

// 增加 @CacheConfig(cacheNames="indexes") 表示缓存的名称是 indexes. 如图所示，保存到 redis 就会以 indexes 命名
@Service
@CacheConfig(cacheNames = "indexes")
public class IndexService {
    private List<Index> indexes;
    @Autowired
    RestTemplate restTemplate;

    // 刷新数据
    // 1.先通过fetch_indexes_from_third_part方法获取数据
    // 2.删除数据
    // 3.保存数据
    // SpringContextUtil.getBean 去重新获取了一次 IndexService，为什么不直接在 fresh 方法里调用 remove, store 方法， 而要重新获取一次呢？
    // 这个是因为 springboot 的机制大概有这么个 bug吧. 从已经存在的方法里调用 redis 相关方法，并不能触发 redis 相关操作，所以只好用这种方式重新获取一次了。

    @HystrixCommand(fallbackMethod = "third_part_not_connected")
    public List<Index> fresh() {
        indexes = fetch_indexes_from_third_part();
        IndexService indexService = SpringContextUtil.getBean(IndexService.class);
        indexService.remove();
        return indexService.store();
    }

    // 在这个方法上添加断路器命令，当服务不可用时，回调third_part_not_connected方法
    // @Cacheable(key="'all_codes'") 表示保存到 redis 用的 key 就会使 all_codes.
    // 'all_codes'表示所有指数代码
    // @HystrixCommand(fallbackMethod = "third_part_not_connected")
    // @Cacheable(key = "'all_codes'")
    public List<Index> fetch_indexes_from_third_part() {
        List<Map> temp = restTemplate.getForObject("http://127.0.0.1:8090/indexes/codes.json", List.class);
        return map2Index(temp);
    }

    public List<Index> third_part_not_connected() {
        System.out.println("third_part_not_connected");
        Index index = new Index();
        index.setName("000000");
        index.setCode("无效指数代码");
        return CollectionUtil.toList(index);
    }

    // 将获取出来的map转换为index
    private List<Index> map2Index(List<Map> temp) {
        List<Index> indexes = new ArrayList<>();
        for (Map map : temp) {
            String code = map.get("code").toString();
            String name = map.get("name").toString();
            Index index = new Index();
            index.setCode(code);
            index.setName(name);
            indexes.add(index);
        }
        return indexes;
    }

    // 清空数据
    @CacheEvict(allEntries = true)
    public void remove() {

    }

    // 获取数据，用来从redis获取数据
    @CachePut(key = "'all_codes'")
    public List<Index> get() {
        return CollUtil.toList();
    }

    // 保存数据，这个专门用来往redis存数据，indexes是一个成员变量
    @Cacheable(key = "'all_codes'")
    public List<Index> store() {
        System.out.println(this);
        return indexes;
    }

}