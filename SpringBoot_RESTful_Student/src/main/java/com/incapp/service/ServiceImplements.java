package com.incapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incapp.Repo.StudentRepo;
import com.incapp.bean.Student;

@Service
public class ServiceImplements implements StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public String addStudents(Student s) {
		
		return studentRepo.addStudent(s);
	}

	@Override
	public List<Student> getAllStudentsData() {
		
		return studentRepo.getAllStudents();
	}

	@Override
	public List<Integer> getAllStudentsIDsOnly() {
		
		return studentRepo.getAllStudentsId();
	}

	@Override
	public List<Student> getAllStudentsNamesLike(String name) {
		
		return studentRepo.getAllStudentsNameLike(name);
	}

	@Override
	public String deleteStudent(String name) {
		
		return studentRepo.deleteStudent(name);
	}

	@Override
	public String updateStudent(int id, Student s) {
		
		return studentRepo.updateStudent(id,s);
		
	}

}
