package com.stormtechio.shinjitsu.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stormtechio.shinjitsu.model.User;
import com.stormtechio.shinjitsu.repository.UserRepository;
import com.stormtechio.shinjitsu.utils.Utils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public Map<String, String> create(User user){
		
		HashMap<String, String> map = new HashMap<String, String>();
		try {

//		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
//		    digest.reset();
//		    digest.update(user.getPassword().getBytes("utf8"));
//		    user.setPassword(String.format("%0128x", new BigInteger(1, digest.digest())));

			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	
			this.userRepository.save(user);
			
			map.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
			map.put(Utils.MESSAGE_KEY, "Added Successfully");	
			
		}catch(Exception e) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "Email already exists, please try to login or choose another email");	
		}
		
		return map;
	}
	
	public List<User> getUsers(){
		return this.userRepository.findAll();
	}

	public User getUserById(Long id) {

		if(id < 0) {
			return null;
		}
		
		Optional<User> user = this.userRepository.findById(id);
		
		if(!user.isPresent()) {
			return null;
		}
		User u = new User();
		
		u.setName(user.get().getName());
		u.setEmail(user.get().getEmail());
		u.setAddress(user.get().getAddress());
		
		return u;
		
	}

	public Map<String, String> updateUser(User user, Long id) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(user == null) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "No user sent to be updated");	
			return map;
		}
		
		if(id < 0) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "Invalid User Id");	
			return map;
		}
		
		Optional<User> userRetrieved = this.userRepository.findById(id);
		if(!userRetrieved.isPresent()) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "No user found with id ["+id+"]");	
			return map;
		}
		
		User newUser = userRetrieved.get();
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		
		this.userRepository.save(newUser);
		
		map.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
		map.put(Utils.MESSAGE_KEY, "Updated Successfully");
		
		return map;
	}

	public Map<String, String> deleteUser(Long id) {
		HashMap<String, String> map = new HashMap<String, String>();

		if(id < 0) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "Invalid User Id");	
			return map;
		}
		try {
			this.userRepository.deleteById(id);
			map.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
			map.put(Utils.MESSAGE_KEY, "Deleted Successfully");
			
			return map;
			
		}catch(EmptyResultDataAccessException e) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "No valid User found with id ["+id+"]");	
			return map;
		}
		
	}
}
