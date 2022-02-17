package com.example.democrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democrud.dao.EmployeeDAO;
import com.example.democrud.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getEmployeeList();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		 employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		employeeDAO.deleteById(employeeId);
	}

}
