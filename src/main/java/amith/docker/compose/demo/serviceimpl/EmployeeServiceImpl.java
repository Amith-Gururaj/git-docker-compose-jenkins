package amith.docker.compose.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amith.docker.compose.demo.entity.Employee;
import amith.docker.compose.demo.repository.EmployeeRepository;
import amith.docker.compose.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository emprepo;
	
	public EmployeeServiceImpl(EmployeeRepository emprepo) {
		super();
		this.emprepo = emprepo;
	}

	@Override
	public Iterable<Employee> getAllEmp() {
		return emprepo.findAll();
	}

	@Override
	public String addEmployee(Employee e) {
		emprepo.save(e);
		return "Employee Added Successfully";
	}

	@Override
	public String updateEmpName(Long id, String newname) {
		emprepo.updateEmpNameWithId(id,newname);
		return "Employee Name Updated Successfully";
	}

	@Override
	public String deleteEmployee(Long id) {
		emprepo.deleteById(id);
		return "Employee Deleted Successfully";
	}

}
