package edu.feng.formlogin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @program: form-login
 * @description: TODO
 * @author: feng
 * @create: 2020-06-17 10:18
 * @version: 1.0
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("abcd").password("123").roles("admin");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }
    // @Override
    // public void configure(WebSecurity web) throws Exception {
    //     //解决静态资源被拦截的问题
    //     web.ignoring().antMatchers("/global/**");
    // }

    // 如果我们使用 XML 来配置 Spring Security ，里边会有一个重要的标签 <http>，HttpSecurity 提供的配置方法 都对应了该标签。
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // authorizeRequests 对应了 <intercept-url>。
        // formLogin 对应了 <formlogin>。
        // and 方法表示结束当前标签，上下文回到HttpSecurity，开启新一轮的配置。
        // permitAll 表示登录相关的页面/接口不要被拦截。
        // 最后记得关闭 csrf ，关于 csrf 问题我到后面专门和大家说。
        // 当我们定义了登录页面为 /login.html 的时候，Spring Security 也会帮我们自动注册一个 /login.html 的接口，这个接口是 POST 请求，用来处理登录逻辑。
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                // .successForwardUrl("/success")// 服务端跳转
                // .defaultSuccessUrl("/success")// 本质上是一个重定向
                .successHandler((req, resp, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(e.getMessage());
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("注销成功");
                    out.flush();
                    out.close();
                })
                .and()
                .csrf().disable();
    }
}
