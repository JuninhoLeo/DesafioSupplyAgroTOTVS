package com.totvs.supplyagro.DesafioSupply;

import com.totvs.tjf.api.jpa.repository.impl.ApiJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableScheduling
@PropertySource("classpath:application.yml")
@EntityScan(basePackages = "com.totvs.supplyagro")
@EnableJpaRepositories(repositoryBaseClass = ApiJpaRepositoryImpl.class, basePackages = "com.totvs.supplyagro")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
