package edu.feng.trend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-12 10:57
 * @version: 1.0
 */
// @RefreshScope表示允许刷新
@Controller
@RefreshScope
public class ViewController {
    @Value("${version}")
    String version;

    @GetMapping("/")
    public String view(Model m) throws Exception {
        m.addAttribute("version", version);
        return "view";
    }
}