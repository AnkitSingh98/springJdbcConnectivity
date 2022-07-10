package com.courseTheory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.courseTheory.models.Product;


@SpringBootApplication
public class CourseTheoryApplication implements CommandLineRunner{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		
		SpringApplication.run(CourseTheoryApplication.class, args);
	}
	
	@Override
	public void run(String...  args) throws Exception{
		
		System.out.println("application started");
		
		String query = "select * from product";
		
		List<Map<String, Object>> list =jdbcTemplate.queryForList(query);
		
		System.out.println(list);
	}

}
