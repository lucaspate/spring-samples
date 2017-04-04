package com.lucaspate.spring.samples.cache.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Cacheable("email-cache")
	public String getEmail(String user) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return user + "@gmail.com";
	}

}
