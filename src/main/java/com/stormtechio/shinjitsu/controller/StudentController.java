package com.stormtechio.shinjitsu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stormtechio.shinjitsu.model.Student;
import com.stormtechio.shinjitsu.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	StudentController(StudentService studentService){
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	@ResponseBody
	public List<Student> getStudents(){
		return this.studentService.getStudents();
	}
	
	@GetMapping("/{id}")
	@ResponseBody  
	public Student getStudent(@PathVariable Long id){
		return this.studentService.getStudent(id);
	}
	
	
	@PostMapping("/")
	@ResponseBody
	public Map<String, String> addStudent(@RequestBody Student student){
		return this.studentService.addStudent(student);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Map<String, String> updateStudent(@RequestBody Student student, @PathVariable Long id){
		return this.studentService.updateStudent(student, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, String> deleteStudent(@PathVariable Long id){
		return this.studentService.deleteStudent(id);
	}
	
}
