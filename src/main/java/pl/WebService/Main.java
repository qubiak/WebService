package pl.WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.WebService.Repository.EmployeeRepository;

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}