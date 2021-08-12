package com.stormtechio.shinjitsu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.stormtechio.shinjitsu.model.User;

public interface UserRepository extends Repository<User, Long>{

	void save(User user);
	void deleteById(Long id);
	List<User> findAll();
	Optional<User> findById(Long id);
    User findByEmail(String login);
}
