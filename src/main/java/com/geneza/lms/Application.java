package com.geneza.lms;

import com.geneza.lms.security.MyCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.servlet.Filter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // @Bean
    // public FilterRegistrationBean myFilter() {
    //     FilterRegistrationBean registration = new FilterRegistrationBean();
    //     Filter myFilter = new MyCorsFilter();
    //     registration.setFilter(myFilter);
    //     registration.addUrlPatterns("/*");
    //     registration.setOrder(-1000);
    //     return registration;
    // }
}