package com.nearsoft.vaultws;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(VaultConfig.class)
public class VaultwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultwsApplication.class, args);
    }

    DataSource dataSource;

    @PostConstruct
    private void postConstruct() throws Exception {

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT CURRENT_USER();");
            resultSet.next();

            System.out.println("Connection works with User: " + resultSet.getString(1));

            resultSet.close();
        }
    }

}
