package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.dataAccess.abstracts.EmployeeDao;
import spring.hrms.entities.concretes.Employee;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
