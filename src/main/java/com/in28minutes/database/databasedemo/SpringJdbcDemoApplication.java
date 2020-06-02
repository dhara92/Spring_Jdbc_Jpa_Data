package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.sleep(1000);
		
		logger.info("Users Id 1001 -> {}", dao.findById(1001));
		logger.info("All users -> {}", dao.findAll());
		
		logger.info("deleteUsers Id 1002 -> numbers of rows deleted - {}", dao.deleteById(1002));
		
		logger.info("Inserting 10004 -> {}", dao.insert(new Person(1004,"Dhara","Surat",new Date()) ));
		
		logger.info("Updateing 10003 -> {}", dao.update(new Person(1003,"kalpesh","Surat",new Date()) ));
		
	
	}
}