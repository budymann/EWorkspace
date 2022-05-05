package com.budymann.OrderService;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.budymann.OrderService.domain.repository")
@Configuration
public class PersistenceConfiguration {
}
