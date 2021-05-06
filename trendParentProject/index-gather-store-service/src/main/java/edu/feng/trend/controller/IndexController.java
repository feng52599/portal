package edu.feng.trend.controller;

import edu.feng.trend.pojo.Index;
import edu.feng.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: trendParentProject
 * @description:
 * @author: feng
 * @create: 2020-05-10 21:23
 */

@RestController
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/freshCodes")
    public List<Index> fresh() throws Exception {
        return indexService.fresh();
    }

    @GetMapping("/getCodes")
    public List<Index> get() throws Exception {
        return indexService.get();
    }

    @GetMapping("/removeCodes")
    public String remove() throws Exception {
        indexService.remove();
        return "removes codes successfully";
    }


}