package com.incapp.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incapp.bean.Student;
import com.incapp.service.StudentService;

@RestController
public class MyController {
	
	@Autowired 
	StudentService studentService;
	
	
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
//	@GetMapping(value = "/books")//by default produce is JSON
//	@GetMapping(value = "/books",produces = {"application/json"}) //only JSON support
//	@GetMapping(value = "/books",produces = {"application/xml"}) //only XML support
	@GetMapping(value = "/student" , produces = {"application/json","application/xml"})
	
  public List<Student> getAllBooks(){
		
		return studentService.getAllStudentsData();
	}
	
	@GetMapping(value ="/studentid",produces = {"application/json","application/xml"})
	public List<Integer> getAllBookIds(){
		
		return studentService.getAllStudentsIDsOnly();
	}
	
	
	@GetMapping(value ="/students/{name}" , produces= {"application/json","application/xml"} )
	public List<Student> getStudentsNamesLike(@PathVariable ("name") String name){
		
	return studentService.getAllStudentsNamesLike(name);
	}
	
	@DeleteMapping(value ="/student/{name}")
	public String delteStudent(@PathVariable ("name") String name) {
		
		return studentService.deleteStudent(name);
	}
	
	@PostMapping(value ="/studentadd" , consumes ={"application/json","application/xml"})
	public String addStudent(@RequestBody Student s) {
		
		return studentService.addStudents(s);
	}
	
	@PutMapping(value ="/studentupdate/{id}" )
	public String updateStudent(@RequestBody Student student , @PathVariable("id") int id) {
		
		return studentService.updateStudent(id, student);
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
