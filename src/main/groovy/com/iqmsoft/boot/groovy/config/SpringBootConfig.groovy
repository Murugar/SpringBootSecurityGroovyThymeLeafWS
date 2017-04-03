package com.iqmsoft.boot.groovy.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.iqmsoft.boot.groovy")
class SpringBootConfig {

    static void main(String[] args){
        new SpringApplicationBuilder()
                .sources(SpringBootConfig.class)
                .run()
    }
}
