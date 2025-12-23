package design.pattern;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Gateway
{
    public static void main( String[] args )
    {
        SpringApplication.run(Gateway.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> {
                    return predicateSpec.path("/api/v1/product/**")
                            .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/api/v1/product/?(<segment>.*)", "/api/v1/product/${segment}"))
                            .uri("lb://PRODUCT");
                })
                .route(predicateSpec -> {
                    return predicateSpec.path("/api/v1/inventory/**")
                            .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/api/v1/inventory/?(<segment>.*)", "/api/v1/inventory/${segment}"))
                            .uri("lb://INVENTORY");
                })
                .build();
    }
}
