package org.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
<<<<<<< HEAD

	DiscoveryClientRouteDefinitionLocator dynamicRoutes (ReactiveDiscoveryClient rdc,
														 DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator( rdc, dlp);
=======
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/books/**").uri("http://localhost:8081/"))
				.build();
>>>>>>> c710175c53d9a25b3b49350f3424d14a6e2109a5
	}
}
