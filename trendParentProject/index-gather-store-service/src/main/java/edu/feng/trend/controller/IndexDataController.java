package edu.feng.trend.controller;

import edu.feng.trend.pojo.Index;
import edu.feng.trend.pojo.IndexData;
import edu.feng.trend.service.IndexDataService;
import edu.feng.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: trendParentProject
 * @description:
 * @author: feng
 * @create: 2020-05-10 21:23
 */

@RestController
public class IndexDataController {
    @Autowired
    IndexDataService indexdataService;

    /**
     * http://127.0.0.1:8001/freshIndexData/000300
     * http://127.0.0.1:8001/getIndexData/000300
     * http://127.0.0.1:8001/removeIndexData/000300
     *
     * @param code
     * @return
     * @throws Exception
     */

    @GetMapping("/freshIndexData/{code}")
    public List<IndexData> fresh(@PathVariable("code") String code) throws Exception {
        return indexdataService.fresh(code);
    }

    @GetMapping("/getIndexData/{code}")
    public List<IndexData> get(@PathVariable("code") String code) throws Exception {
        return indexdataService.get(code);
    }

    @GetMapping("/removeIndexData/{code}")
    public String remove(@PathVariable("code") String code) throws Exception {
        indexdataService.remove(code);
        return "removes index Data successfully";
    }


}