package com.zhong.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/").permitAll()
                        .antMatchers("/level1/**").hasRole("vip1")
                        .antMatchers("/level2/**").hasRole("vip2")
                        .antMatchers("/level3/**").hasRole("vip3")
                )
                //定制登录页，并且指定处理登陆请求的控制器。这里表单提交必须要是post
                .formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
        //关闭默认开启的网站防御攻击，以此支持跨域请求
        http.csrf().disable();
        http.rememberMe().rememberMeParameter("remember");

        //开启注销功能，并清除cookie，清除session.但实际上一般不会这么干
//        http.logout().deleteCookies("remove").invalidateHttpSession(true);
        //开启注销功能，并让它注销成功之后跳转到我们指定的路径
        http.logout().logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {


        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("root")
                .password("123456")
                .roles("vip1")
                .build();

        //该设置密码加密的方式已经弃用，只用来写代码示例
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("zhong")
                .password("123456")
                .roles("vip1")
                .build();
        return new InMemoryUserDetailsManager(user,user2);
    }

}
