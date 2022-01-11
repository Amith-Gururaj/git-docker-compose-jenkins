package amith.docker.compose.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amith.docker.compose.demo.entity.Employee;
import amith.docker.compose.demo.service.EmployeeService;

@RestController
@RequestMapping(path="/employee")
@CrossOrigin(origins = "*")
public class EmployeeController 
{
	@Autowired
	private EmployeeService empservice;

	public EmployeeController(EmployeeService empservice) {
		super();
		this.empservice = empservice;
	}
	
	@GetMapping(path="/demo")
	public String check()
	{
		return "FullStack program is working fine!!";
	}
	
	@GetMapping(path="/getall")
	public Iterable<Employee> getEmp()
	{
		return empservice.getAllEmp();
	}
	
	@PostMapping(path="/add")
	public String addEmp(@RequestBody Employee e)
	{
		return empservice.addEmployee(e);
	}
	
	@PutMapping(path="/update/{id}/{newname}")
	public String updateEmp(@PathVariable Long id,@PathVariable String newname)
	{
		return empservice.updateEmpName(id,newname);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteEmp(@PathVariable Long id)
	{
		return empservice.deleteEmployee(id);
	}
}
