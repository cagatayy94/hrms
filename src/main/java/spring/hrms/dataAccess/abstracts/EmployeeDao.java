package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Employee;
import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmail(String email);
}
