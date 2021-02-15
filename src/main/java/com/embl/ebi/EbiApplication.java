package com.embl.ebi;

//import com.embl.ebi.auth.config.KeycloakServerProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;


@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
//@EnableConfigurationProperties({KeycloakServerProperties.class})
public class EbiApplication {
    private static final Logger LOG = LoggerFactory.getLogger(EbiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EbiApplication.class, args);
    }

    /*@Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties,
                                                                               KeycloakServerProperties keycloakServerProperties) {

        return (evt) -> {

            Integer port = serverProperties.getPort();
            String keycloakContextPath = keycloakServerProperties.getContextPath();

            LOG.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak", port, keycloakContextPath);
        };
    }*/
}
