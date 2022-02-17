/*
 * package com.example.democrud.restcontroller;
 * 
 * import java.util.List;
 * 
 * import javax.annotation.ManagedBean;
 * 
 * import org.ocpsoft.rewrite.annotation.Join; import
 * org.ocpsoft.rewrite.el.ELBeanName; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Scope; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.democrud.entity.Employee; import
 * com.example.democrud.service.EmployeeService;
 * 
 * @RestController
 * 
 * @RequestMapping("/employee")
 * 
 * @Scope (value = "session")
 * 
 * @Component (value = "employeeList")
 * 
 * @ELBeanName(value = "employeeList")
 * 
 * @Join(path = "/", to = "/employee-list.jsf") public class
 * EmployeeRestController {
 * 
 * @Autowired EmployeeService employeeService;
 * 
 * private List<Employee> employees;
 * 
 * public void onload() { this.employees = employeeService.getAllEmployees(); }
 * 
 * @GetMapping("/employees") public List<Employee> getAllEmployees(){ return
 * employeeService.getAllEmployees(); }
 * 
 * @GetMapping("/employees/{employeeId}") public Employee
 * getEmployee(@PathVariable int employeeId) { Employee theEmployee =
 * employeeService.findById(employeeId); if(theEmployee == null) { throw new
 * RuntimeException("Employee is null"); } return theEmployee;
 * 
 * }
 * 
 * @PostMapping("employees") public Employee AddEmployee(@RequestBody Employee
 * employee) { //if someone passes id in the post request employee.setId(0);
 * employeeService.save(employee); return employee;
 * 
 * }
 * 
 * @PutMapping("employees") public Employee updateEmployee(@RequestBody Employee
 * employee) { employeeService.save(employee); return employee; }
 * 
 * @DeleteMapping("/employees/{employeeId}") public String
 * deleteEmployee(@PathVariable int employeeId) { Employee employee =
 * employeeService.findById(employeeId); if(employee == null) { throw new
 * RuntimeException("Employee id is incorrect, Please give a valid Employee id"
 * ); } employeeService.deleteById(employeeId); return
 * employee.getFirstname()+" is Deleted having id: "+employeeId; } }
 */