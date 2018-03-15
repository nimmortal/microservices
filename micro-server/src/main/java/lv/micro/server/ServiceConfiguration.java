package lv.micro.server;

import lv.micro.server.movie.MovieService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {
        MovieService.class
})
public class ServiceConfiguration {
}
