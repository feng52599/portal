package edu.feng.trend;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class IndexCodeService {

    public static void main(String[] args) {

        int port = 0;
        int defaultPort = 8011;
        int redisPort = 6379;
        int eurekaPort = 8761;
        // 如果端口没被占用，说明未启动
        if (NetUtil.isUsableLocalPort(redisPort)) {
            System.err.printf("未在端口%d 发现 redis服务，请检查redis 是否启动", redisPort);
            System.exit(1);
        }

        if (NetUtil.isUsableLocalPort(eurekaPort)) {
            System.err.printf("未在端口%d 发现eurekaPort服务，请检查eurekaPort是否启动", eurekaPort);
            System.exit(1);
        }


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
        if (0 == port) {
            Future<Integer> future = ThreadUtil.execAsync(() -> {
                int p = 0;
                System.out.println("请于5秒钟内输入端口号, 推荐  8011 、 8012  或者  8013，超过5秒将默认使用" + defaultPort);
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String strPort = scanner.nextLine();
                    if (!NumberUtil.isInteger(strPort)) {
                        System.err.println("只能是数字");
                        continue;
                    } else {
                        p = Convert.toInt(strPort);
                        scanner.close();
                        break;
                    }
                }
                return p;
            });
            try {
                port = future.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                port = defaultPort;
            }
        }
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(IndexCodeService.class).properties("server.port=" + port).run(args);

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}