package com.stormtechio.shinjitsu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stormtechio.shinjitsu.model.Student;
import com.stormtechio.shinjitsu.repository.StudentRepository;
import com.stormtechio.shinjitsu.utils.Utils;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents(){
		return this.studentRepository.findAll();
	}
	
	public Student getStudent(Long id){
		
		if(id < 0) {
			return null;
		}
		
		Optional<Student> student= this.studentRepository.findById(id);
		if(!student.isPresent()) {
			return null; 
		}
		
		return student.get();
	}
	
	public Map<String, String> addStudent(Student student){
		Map<String, String> response = new HashMap<>();
		if(student == null) {
			 response.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);
			 response.put(Utils.MESSAGE_KEY, "No student was sent to the server or the Id is not valid");
			 return response;
		}
		
		this.studentRepository.save(student);
		
		response.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
		response.put(Utils.MESSAGE_KEY, "Student saved sucessfuly");
		return response;
	}
	
	public Map<String, String> updateStudent(Student student, Long id){
		Optional<Student> possibleStudent = this.studentRepository.findById(id);
		Map<String, String> response = new HashMap<>();

		if(!possibleStudent.isPresent()) {
			response.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);
			 response.put(Utils.MESSAGE_KEY, "No student was found with this id ["+id+"]");
			 return response;
		}
		
		Student studentRetrieved =  possibleStudent.get();
		
		studentRetrieved.setAge(student.getAge());
		studentRetrieved.setEmail(student.getEmail());
		studentRetrieved.setCellphone(student.getCellphone());
		studentRetrieved.setChronicalDesease(student.hasChronicalDesease());
		studentRetrieved.setDesease(student.hasDesease());
		studentRetrieved.setCity(student.getCity());
		studentRetrieved.setComplement(student.getComplement());
		studentRetrieved.setLawResponsible(student.getLawResponsible());
		studentRetrieved.setName(student.getName());
		studentRetrieved.setNeighborhood(student.getNeighborhood());
		studentRetrieved.setNumber(student.getNumber());
		studentRetrieved.setState(student.getState());
		studentRetrieved.setStreet(student.getStreet());
		studentRetrieved.setSurgery(student.hadSurgery());
		studentRetrieved.setTelephone(student.getTelephone());
		
		
		
		this.studentRepository.save(studentRetrieved);
		
		response.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
		response.put(Utils.MESSAGE_KEY, "Student updated sucessfuly");
		return response;
	
	}

	public Map<String, String> deleteStudent(Long id){
		HashMap<String, String> map = new HashMap<String, String>();

		if(id < 0) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "Invalid User Id");	
			return map;
		}
		try {
			this.studentRepository.deleteById(id);
			map.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
			map.put(Utils.MESSAGE_KEY, "Deleted Successfully");
			
			return map;
			
		}catch(EmptyResultDataAccessException e) {
			map.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);	
			map.put(Utils.MESSAGE_KEY, "No valid Student found with id ["+id+"]");	
			return map;
		}
		
	}
}
