package by.it_academy.bootcamp.users;

import by.it_academy.bootcamp.users.dao.api.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaRepositories(
        basePackageClasses = UserDao.class
)
@EnableOpenApi
public class UserServiceApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
