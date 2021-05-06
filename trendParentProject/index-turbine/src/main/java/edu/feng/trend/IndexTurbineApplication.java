package edu.feng.trend;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
// 支持聚合监控
// 8080 端口可能有冲突
@SpringBootApplication
@EnableTurbine
public class IndexTurbineApplication {
    public static void main(String[] args) {
        int port = 8080;
        int eurekaServerPort = 8761;

        if (NetUtil.isUsableLocalPort(eurekaServerPort)) {
            System.err.printf("检查到端口%d 未启用，判断 eureka 服务器没有启动，本服务无法使用，故退出%n", eurekaServerPort);
            System.exit(1);
        }
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(IndexTurbineApplication.class).properties("server.port=" + port).run(args);

    }

    // 必须加上这个 才能运行 turbine 否则一直loading 只需要在turbine的application里加就行了
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }


}
