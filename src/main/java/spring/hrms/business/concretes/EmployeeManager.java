package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.EmployeeService;
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

    @Override
    public void add(Employee employee) {
        this.employeeDao.save(employee);
    }

    @Override
    public boolean employeeExist(String email) {
        List<Employee> employeeExist =  this.employeeDao.findByEmail(email);

        return !employeeExist.isEmpty();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return this.employeeDao.getEmployeeById(id);
    }
}
