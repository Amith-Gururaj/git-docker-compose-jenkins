package amith.docker.compose.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.docker.compose.demo.entity.Employee;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	@Modifying
	@Query("update Employee e set e.name=?2 where e.id=?1")
	public int updateEmpNameWithId(Long id, String newname);
}
