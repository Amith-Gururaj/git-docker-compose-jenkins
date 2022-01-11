package amith.docker.compose.demo.service;

import amith.docker.compose.demo.entity.Employee;

public interface EmployeeService 
{

	public Iterable<Employee> getAllEmp();

	public String addEmployee(Employee e);

	public String updateEmpName(Long id, String newname);

	public String deleteEmployee(Long id);

}
