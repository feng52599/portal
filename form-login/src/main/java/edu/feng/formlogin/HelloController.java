package edu.feng.formlogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * S
 *
 * @description: TODO
 * @author: feng
 * @create: 2020-06-17 09:45
 * @version: 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}