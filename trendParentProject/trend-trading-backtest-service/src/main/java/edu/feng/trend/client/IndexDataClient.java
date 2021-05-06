package edu.feng.trend.client;

import edu.feng.trend.pojo.IndexData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-12 07:41
 * @version: 1.0
 */

// 此注解说明是服务调用 value 是调用服务名
//    当数据微服务调用失败时就会调用断路器类，
@FeignClient(value = "INDEX-DATA-SERVICE", fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {

    @GetMapping("/data/{code}")
    public List<IndexData> getIndexData(@PathVariable("code") String code);
}