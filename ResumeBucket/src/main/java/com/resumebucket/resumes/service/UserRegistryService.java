package com.resumebucket.resumes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebucket.resumes.document.User;
import com.resumebucket.resumes.error.ResumeBucketException;
import com.resumebucket.resumes.mapper.UserMapper;
import com.resumebucket.resumes.model.SignUpRequest;
import com.resumebucket.resumes.model.SignUpResponse;
import com.resumebucket.resumes.repository.UserRepository;
import com.resumebucket.resumes.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRegistryService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;
	

	public SignUpResponse signUp(SignUpRequest signUpRequest) throws ResumeBucketException {
		
		SignUpResponse signUpResponse = null;

		userValidator.validateSignUpRequest(signUpRequest);
		User user = userMapper.toUser(signUpRequest);
		User savedUser = userRepository.save(user);
		signUpResponse = userMapper.toSignUpResponse(savedUser);
		
		log.info("User saved. SignUpResponse: " + signUpResponse.toString());

		return signUpResponse;
		
	}
}
