package com.stormtechio.shinjitsu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.stormtechio.shinjitsu.model.User;
import com.stormtechio.shinjitsu.repository.UserRepository;


public class UserServiceTest {
	
	
	private UserService userService;
	private UserRepository userRepository = Mockito.mock(UserRepository.class);
	
	public UserServiceTest() {
		this.userService = new UserService(this.userRepository);
	}
	
	@Test
	@DisplayName("This method should check whether the user list is null or not")
	void userListShouldNotBeNull(){
		User user = getDummyUser();
		
		List<User> users = new ArrayList<User>();
		users.add(user);
		System.out.println(users);
		Assertions.assertFalse(users == null);
	}
	
	@Test
	void checkIfAnUserExistsBasedOnAnId() {
		Long id = (long) 8;
		Mockito.when(this.userRepository.findById(id)).thenReturn(Optional.of(getDummyUser()));
		Mockito.verify(this.userRepository, Mockito.times(1));
	}
		
	@Test
	void userHasNoPasswordInTheObject() {
		Long id = (long) 8;
		User user = getDummyUser();
		Assertions.assertNull(user.getPassword());
	}

	User getDummyUser() {
		User user = new User();
		user.setName("Ayrton");
		user.setEmail("test@test.com");
		user.setAddress("Address 123"); 
		return user;
	}
}
