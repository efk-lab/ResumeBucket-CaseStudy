package com.resumebucket.resumes.repository;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.resumebucket.resumes.document.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
	
	Optional<User> findByEmail(String email);
	
}