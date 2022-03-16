package com.hr.igradiski.app.tennis.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.hr.igradiski.app.tennis.domain.repository.jpa")
@EnableJpaAuditing
@EnableTransactionManagement
public class JpaConfiguration {
}
