package edu.feng.trend.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.feng.trend.pojo.IndexData;
import edu.feng.trend.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: trendParentProject
 * @description:
 * @author: feng
 * @create: 2020-05-10 21:06
 */

// 增加 @CacheConfig(cacheNames="indexes") 表示缓存的名称是 indexes. 如图所示，保存到 redis 就会以 indexes 命名
//    @CacheConfig：该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，那么会自动使用cahceNames配置参数并且追加方法名。
@Service
@CacheConfig(cacheNames = "index_datas")
public class IndexDataService {
    private Map<String, List<IndexData>> indexDatas = new HashMap<>();
    @Autowired
    RestTemplate restTemplate;

    // 刷新数据
    // 1.先通过fetch_indexes_from_third_part方法获取数据
    // 2.删除数据
    // 3.保存数据
    // SpringContextUtil.getBean 去重新获取了一次 IndexService，为什么不直接在 fresh 方法里调用 remove, store 方法， 而要重新获取一次呢？
    // 这个是因为 springboot 的机制大概有这么个 bug吧. 从已经存在的方法里调用 redis 相关方法，并不能触发 redis 相关操作，所以只好用这种方式重新获取一次了。

    @HystrixCommand(fallbackMethod = "third_part_not_connected")
    public List<IndexData> fresh(String code) {
        List<IndexData> indexeDatas = fetch_indexes_from_third_part(code);
        indexDatas.put(code, indexeDatas);
        System.out.println("code: " + code);
        System.out.println("indexeDatas: " + indexDatas.get(code).size());
        IndexDataService indexDataService = SpringContextUtil.getBean(IndexDataService.class);
        indexDataService.remove(code);
        return indexDataService.store(code);
    }

    // 在这个方法上添加断路器命令，当服务不可用时，回调third_part_not_connected方法
    // @Cacheable(key="'all_codes'") 表示保存到 redis 用的 key 就会使 all_codes.
    // 'all_codes'表示所有指数代码
    // @HystrixCommand(fallbackMethod = "third_part_not_connected")
    // @Cacheable(key = "'all_codes'")
    public List<IndexData> fetch_indexes_from_third_part(String code) {
        List<Map> temp = restTemplate.getForObject("http://127.0.0.1:8090/indexes/" + code + ".json", List.class);
        return map2IndexData(temp);
    }

    public List<IndexData> third_part_not_connected(String code) {
        System.out.println("third_part_not_connected");
        IndexData index = new IndexData();
        index.setClosePoint(0);
        index.setDate("n/a");
        return CollectionUtil.toList(index);
    }

    // 将获取出来的map转换为index
    private List<IndexData> map2IndexData(List<Map> temp) {
        List<IndexData> indexDatas = new ArrayList<>();
        for (Map map : temp) {
            String date = map.get("date").toString();
            float closePoint = Convert.toFloat(map.get("closePoint"));
            IndexData indexData = new IndexData();
            indexData.setDate(date);
            indexData.setClosePoint(closePoint);
            indexDatas.add(indexData);
        }
        return indexDatas;
    }

    // 清空数据 这个位置要➕code
    @CacheEvict(key = "'indexData-code-'+#p0")
    public void remove(String code) {

    }

    // 获取数据，用来从redis获取数据
    @CachePut(key = "'indexData-code-'+#p0")
    public List<IndexData> get(String code) {
        return CollUtil.toList();
    }

    // 保存数据，这个专门用来往redis存数据，indexes是一个成员变量
    // 指数数据存放的key 是 indexData-code-000300 这种风格
    @Cacheable(key = "'indexData-code-'+#p0")
    public List<IndexData> store(String code) {
        System.out.println(this);
        return indexDatas.get(code);
    }

}