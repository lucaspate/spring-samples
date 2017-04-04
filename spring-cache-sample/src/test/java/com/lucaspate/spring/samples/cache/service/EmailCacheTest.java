package com.lucaspate.spring.samples.cache.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucaspate.spring.samples.cache.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailCacheTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void when_same_user_is_called_twice_verify_that_email_instances_are_the_same() {
		String email1 = userService.getEmailByUser("me");
		String email2 = userService.getEmailByUser("me");
		assertThat(email1).isSameAs(email2);
	}
	
	@Test
	public void when_cache_is_not_used_verify_that_the_same_user_gets_different_email_instances() {
		UserRepository userRepository = new UserRepository();
		String email1 = userRepository.getEmail("me");
		String email2 = userRepository.getEmail("me");
		assertThat(email1).isEqualTo(email2);
		assertThat(email1).isNotSameAs(email2);
	}
	
	@Test
	public void when_different_users_emails_are_looked_up_verify_that_they_do_not_have_the_same_email() {
		String email1 = userService.getEmailByUser("user1");
		String email2 = userService.getEmailByUser("user2");
		assertThat(email1).isNotEqualTo(email2);
	}
}
