package com.amigo.app.config;

import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@Log4j2
@FieldDefaults(makeFinal = false)
public class CustomerConfiguration {

    @Value("${app.useMockRepository:false}")
    Boolean useMockRepository;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Use mock repository: " + useMockRepository);
            log.info("Command line runner");
        };
    }
}
