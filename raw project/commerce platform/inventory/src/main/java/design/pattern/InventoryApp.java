package design.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients(basePackages = "design.pattern.product")
public class InventoryApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryApp.class, args);
    }
}
