package edu.feng.trend.controller;

import edu.feng.trend.config.IpConfiguration;
import edu.feng.trend.pojo.IndexData;
import edu.feng.trend.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-11 09:21
 * @version: 1.0
 */

@RestController
public class IndexDataController {
    @Autowired
    IndexDataService indexDataService;
    @Autowired
    IpConfiguration ipConfiguration;

//  http://127.0.0.1:8021/data/000300

    @GetMapping("/data/{code}")
    public List<IndexData> get(@PathVariable("code") String code) throws Exception {
        System.out.println("current instance is :" + ipConfiguration.getPort());
        return indexDataService.get(code);
    }
}