package com.stormtechio.shinjitsu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.stormtechio.shinjitsu.model.Student;
import com.stormtechio.shinjitsu.model.User;

public interface StudentRepository extends Repository<Student, Long>{
	
	void save(Student student);
	void deleteById(Long id);
	List<Student> findAll();
	Optional<Student> findById(Long id);

}
