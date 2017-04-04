package com.lucaspate.spring.samples.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheSampleApplication.class, args);
	}
}
