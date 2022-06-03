package com.incapp.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.incapp.bean.Student;

@Repository
public class StudentRepo {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	

	//addStudent 
	public String addStudent(Student s) {
		
		try {
			String query = "insert into student values (?,?,?,?)";
	  int x=jdbcTemplate.update(query , new Object[] {s.getId() , s.getName() , s.getRoll() ,s.getCourse()});
			
	  if(x!=0) {
		  return"Sucess";
			  }
	  else {
			return"Failed";
		}

		} catch (Exception e) {
			e.printStackTrace();
			return"Failed";
		}	
	}
	
	
	//get All Students 
	
 public List<Student> getAllStudents() {
		
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Student s = new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRoll(rs.getInt("roll"));
				s.setCourse(rs.getString("course"));
				
				return s;
			}
		}
		    try {
		    	  final String query = "select * from student";
			       List<Student> data = jdbcTemplate.query(query, new DataMapper());
			 
			       return data;
				
			} catch (Exception e) {
				
				return null;
			}
 }
 
 
 
 
     //get Student Name Like 
 
 public List<Student> getAllStudentsNameLike(String name) {
		
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Student s = new Student();
				
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRoll(rs.getInt("roll"));
				s.setCourse(rs.getString("course"));
				
				return s;
			}
		}
		    try {
		    	  final String query = "select * from student where name like ?";
			       List<Student> data = jdbcTemplate.query(query, new DataMapper() , new Object[]{"%"+name+"%"});
			       
			       return data;
				
			} catch (Exception e) {
				
				return null;
			}		    
}
	  
 
        
 
        //getAllStudents By ID 
 
    public List<Integer> getAllStudentsId(){
    	
    	class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("id");
			}
    	}
    	
    	try {
    		
    		String query = "select * from student";
    		 List<Integer> data = jdbcTemplate.query(query, new DataMapper());
    		 
    		 return data;
		} catch (Exception e) {
			return null;
		}
    }
    
    
    
    //updateStudent 
    
    public String  updateStudent(int id , Student s ) {
    	
      String query =  "update student set id=? , name=? , roll=? , course=? where id=?";
      int x = jdbcTemplate.update(query , new Object[] {s.getId() , s.getName() , s.getRoll() , s.getCourse() , id });
      
      if (x!=0) {
       		return "Success";
	
      }else {
		return "Failed";
	}
}     
    
    
    
    //delete Student 
    
    public String deleteStudent(String name) {
    	
    	String query = "delete from student where name=?";
    	int x = jdbcTemplate.update(query , new Object[] {name});
    	
    	if (x!=0) {
       		return "Success";
	
      }else {
		return "Failed";
	}
    	
    	
    }
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
