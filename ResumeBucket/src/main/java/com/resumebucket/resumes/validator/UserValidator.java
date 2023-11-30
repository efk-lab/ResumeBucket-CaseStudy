package com.resumebucket.resumes.validator;

import org.springframework.stereotype.Component;

import com.resumebucket.resumes.error.ResumeBucketException;
import com.resumebucket.resumes.model.SignUpRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserValidator extends BaseValidator {

	public void validateSignUpRequest(SignUpRequest signUpRequest) throws ResumeBucketException {

		validateEmail(signUpRequest.getEmail());

		log.info("SignUpRequest validated. SignUpRequest: " + signUpRequest.toString());

	}

	private void validateEmail(String email) {

		if (userRepository.findByEmail(email).isPresent()) {
			throw new ResumeBucketException("User already registed.");
		}

	}

	
}
