package design.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class DiscountApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(DiscountApp.class, args);
    }
}
