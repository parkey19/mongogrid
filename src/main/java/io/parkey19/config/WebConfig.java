package io.parkey19.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by parkey19 on 2018. 12. 4..
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${vue.allow.origin.url}")
    private String allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(allowedOrigins);
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                .allowCredentials(true);
    }
}
