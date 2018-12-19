package com.v.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author v
 * Date 2018-04-19
 */
@Configuration
public class OAuth2ServerConfig {


    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    //配置security访问控制，必须认证过后才可以访问
                    .antMatchers("/api/**")
                    .authenticated()
                    //支持跨域
                    .and()
                    .cors()
                    .and()
                    .rememberMe()
                    .and()
                    .csrf()
                    .disable();
        }
    }

}
