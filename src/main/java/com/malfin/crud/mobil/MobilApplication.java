package com.malfin.crud.mobil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@ComponentScan({"com.malfin.crud.mobil.*"})
@EntityScan(basePackages = {"com.malfin.crud.mobil.entity"})
@EnableJpaRepositories("com.malfin.crud.mobil.repo")
public class MobilApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MobilApplication.class, args);
	}

}
