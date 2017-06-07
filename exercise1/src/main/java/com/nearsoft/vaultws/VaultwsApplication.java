package com.nearsoft.vaultws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApiConfiguration.class)
public class VaultwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultwsApplication.class, args);
    }
}
