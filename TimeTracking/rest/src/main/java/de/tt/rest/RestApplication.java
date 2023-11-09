package de.tt.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Base RestApplication
 *
 * Disable default HATEOAS with exclude <code>org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration</code>
 *
 */
@SpringBootApplication(scanBasePackages = { "de.tt.rest", "de.tt.service", "de.tt.persistence", "de.tt.application.config"})
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
