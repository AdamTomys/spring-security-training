package com.amigo.app.jsonplaceholder;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
@Log4j2
public class JSONPlaceHolderConfiguration {

    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceHolderClient jsonPlaceHolderClient) {
        return args -> {
            log.info("Received data from JsonPlaceHolder by feign:");
            log.info(jsonPlaceHolderClient.getPosts().size());
            log.info(jsonPlaceHolderClient.getPost(1));
        };
    }
}
