package edu.feng.trend.controller;

import edu.feng.trend.config.IpConfiguration;
import edu.feng.trend.pojo.Index;
import edu.feng.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class IndexController {
    @Autowired
    IndexService indexService;
    @Autowired
    IpConfiguration ipConfiguration;

    @GetMapping("/codes")
    @CrossOrigin
    public List<Index> codes() throws Exception {
        System.out.println("current instance'port is " + ipConfiguration.getPort());
        return indexService.get();
    }
}