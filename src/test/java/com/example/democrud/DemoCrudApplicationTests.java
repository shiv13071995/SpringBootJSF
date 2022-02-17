package com.example.democrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.democrud.entity.Employee;
import com.example.democrud.service.EmployeeService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class DemoCrudApplicationTests {
	@Autowired
	private EmployeeService employeeservice;
	
	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee("fazal", "atrachali", "fazal@PKL.com");
		employeeservice.save(employee);
		List<Employee> employees = employeeservice.getAllEmployees();
		Employee savedEmployee = employees.get(employees.size()-1);
		assertTrue(savedEmployee.getId() == employee.getId());
	}
	
	@Test
	public void testUpdateEmployee() {
		int id = 30;
		Employee employee = new Employee(id,"shiv", "swamy", "siva@kkd.com");
		employeeservice.save(employee);
		Employee updatedEmployee = employeeservice.findById(id);
		assertEquals("swamy", updatedEmployee.getLastname());
	}
	@Test
	public void testDeleteEmployee() {
		int id = 29;
		employeeservice.deleteById(id);
		assertNull(employeeservice.findById(id));
	}
	@Test
	public void testListEmployees() {
		List<Employee> employees = employeeservice.getAllEmployees();
		assertFalse(employees.isEmpty());
	}
	
}
