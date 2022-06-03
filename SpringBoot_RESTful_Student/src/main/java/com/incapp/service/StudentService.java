package com.incapp.service;

import java.util.List;

import com.incapp.bean.Student;

public interface StudentService {
	
	
  public String addStudents(Student s); 
  
  public List<Student> getAllStudentsData();
  
  public List<Integer> getAllStudentsIDsOnly();
  
  public List<Student> getAllStudentsNamesLike(String name);
  
  public String deleteStudent(String name);
  
  public String updateStudent(int id , Student s);
  
  
  
	
}
