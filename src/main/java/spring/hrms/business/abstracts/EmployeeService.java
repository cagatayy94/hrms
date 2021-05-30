package spring.hrms.business.abstracts;

import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
}
