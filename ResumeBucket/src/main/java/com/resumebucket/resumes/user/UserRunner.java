package com.resumebucket.resumes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.resumebucket.resumes.constant.Role;
import com.resumebucket.resumes.document.User;
import com.resumebucket.resumes.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class UserRunner implements CommandLineRunner {

	@Value("${admin.user.email}")
	private String adminEmail;

	@Value("${admin.user.password}")
	private String adminPassword;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public void run(String... args) throws Exception {

		if(userRepository.findByEmail(adminEmail).isEmpty()) {
			User adminUser = new User();
			
			adminUser.setEmail(adminEmail);
			adminUser.setPassword(passwordEncoder.encode(adminPassword));
			adminUser.setRole(Role.ADMIN);
			
			userRepository.save(adminUser);
		}
		
		log.info("Admin user saved.");
	}

}
