package edu.feng.trend.client;

import cn.hutool.core.collection.CollectionUtil;
import edu.feng.trend.pojo.IndexData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-12 07:49
 * @version: 1.0
 */

@Component
public class IndexDataClientFeignHystrix implements IndexDataClient {
    @Override
    public List<IndexData> getIndexData(String code) {
        IndexData indexData = new IndexData();
        indexData.setDate("0000-00-00");
        indexData.setClosePoint(0);
        return CollectionUtil.toList(indexData);
    }
}