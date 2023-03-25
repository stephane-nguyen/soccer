package com.graphql.soccerDetails.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.graphql.soccerDetails.repository")
public class JpaConfig {

}
