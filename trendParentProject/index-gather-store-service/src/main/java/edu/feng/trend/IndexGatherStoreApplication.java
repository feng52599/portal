package edu.feng.trend;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableHystrix 来启动断路器
 * @EnableCaching 表示启动缓存
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCaching
public class IndexGatherStoreApplication {
    public static void main(String[] args) {
        int port = 0;
        int defaultport = 8001;
        int eurekaServerPort = 8761;
        int redisPort = 6379;
        port = defaultport;

        // 检测eureka服务器是否启用
        if (NetUtil.isUsableLocalPort(eurekaServerPort)) {
            System.err.printf("检查到端口%d 未启用，判断 eureka 服务器没有启动，本服务无法使用，故退出%n", eurekaServerPort);
            System.exit(1);
        }
        if (NetUtil.isUsableLocalPort(redisPort)) {
            System.err.printf("检查到端口%d 未启用，判断 redis 服务器没有启动，本服务无法使用，故退出%n", redisPort);
            System.exit(1);
        }


        // 这一段就表示启动的时候如果带了参数，如： port=8099, 那么程序就会使用 8099 作为端口号了。
        // 这样做的好处是，什么代码都不用改，只需要在启动的时候带不同的参数，就可以启动不同的端口了。
        if (null != args && 0 != args.length) {
            for (String arg : args) {
                if (arg.startsWith("port=")) {
                    String strPort = StrUtil.subAfter(arg, "port=", true);
                    if (NumberUtil.isNumber(strPort)) {
                        port = Convert.toInt(strPort);
                    }
                }
            }
        }


        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(IndexGatherStoreApplication.class).properties("server.port=" + port).run(args);

    }

    /**
     * 需要在启动类添加这个类方法，才能使用restTemplate
     *
     * @return
     */
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}