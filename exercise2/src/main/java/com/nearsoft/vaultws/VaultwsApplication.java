package com.nearsoft.vaultws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import com.nearsoft.model.Secrets;


@SpringBootApplication
public class VaultwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultwsApplication.class, args);

        VaultEndpoint vaultEndpoint = VaultEndpoint.create();
        VaultTemplate vaultTemplate = new VaultTemplate(vaultEndpoint,
                new TokenAuthentication(""));

        Secrets secrets = new Secrets();
        vaultTemplate.write();

        VaultResponseSupport<Secrets> response = vaultTemplate.read();
        System.out.println(response.getData().getUsername());
        System.out.println(response.getData().getPassword());

        //delete


    }
}
