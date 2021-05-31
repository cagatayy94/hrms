package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.entities.concretes.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("getAll")
    public DataResult<List<Employee>> getAll(){
        return new SuccessDataResult<>(this.employeeService.getAll());
    }
}
