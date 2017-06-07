package com.nearsoft.vaultws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@Import()
@VaultPropertySource()
public class ApiConfiguration {

    private String apiKey;

    @Bean
    public String readApiKey(){
        return apiKey;
    }

}
