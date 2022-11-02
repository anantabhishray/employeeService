package com.greatLearning.employeeService.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.greatLearning.employeeService.dao.EmployeeRepository;
import com.greatLearning.employeeService.dao.UserRepository;
import com.greatLearning.employeeService.entity.Employee;
import com.greatLearning.employeeService.entity.Role;
import com.greatLearning.employeeService.entity.User;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootStrapAppData {
	
	private final EmployeeRepository employeeRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		Employee ramesh = new Employee();
		ramesh.setFirstName("Ramesh");
		ramesh.setLastName("Kumar");
		ramesh.setEmail("ramesh@gmail.com");
		this.employeeRepository.save(ramesh);
		
		Employee suresh = new Employee();
		ramesh.setFirstName("Suresh");
		ramesh.setLastName("Kumar");
		ramesh.setEmail("suresh@gmail.com");
		this.employeeRepository.save(suresh);
		
		
		User vinay = new User();
		vinay.setUsername("vinay");
		vinay.setPassword(this.passwordEncoder.encode("admin"));
		vinay.setEmailAddress("vinay@gmail.com");
		
		
		Role userRole = new Role();
		userRole.setRoleName("USER");
		userRole.setUser(vinay);
		
	}
	
	

}

