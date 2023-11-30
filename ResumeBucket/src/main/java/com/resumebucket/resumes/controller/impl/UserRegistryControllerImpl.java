package com.resumebucket.resumes.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.resumebucket.resumes.controller.UserRegistryController;
import com.resumebucket.resumes.error.ResumeBucketException;
import com.resumebucket.resumes.model.SignUpRequest;
import com.resumebucket.resumes.model.SignUpResponse;
import com.resumebucket.resumes.service.UserRegistryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserRegistryControllerImpl implements UserRegistryController {

	@Autowired
	private UserRegistryService userService;
	

	@Override
	public ResponseEntity<SignUpResponse> signUp(SignUpRequest signUpRequest) throws ResumeBucketException {
		
		log.info("SignUpRequest received: " + signUpRequest.toString());

		SignUpResponse signUpResponse = userService.signUp(signUpRequest);

		if (signUpResponse != null) {
			return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(signUpResponse, HttpStatus.NO_CONTENT);
		}
		
	}
}
