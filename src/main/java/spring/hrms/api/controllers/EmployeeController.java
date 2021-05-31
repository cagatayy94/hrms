package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.business.abstracts.MernisService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Employee;
import spring.hrms.entities.concretes.dtos.EmployeeDto;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final MernisService mernisService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, MernisService mernisService) {
        this.employeeService = employeeService;
        this.mernisService = mernisService;
    }

    @GetMapping("getAll")
    public DataResult<List<Employee>> getAll(){
        return new SuccessDataResult<>(this.employeeService.getAll());
    }

    @PostMapping("add")
    public Result add(@RequestBody EmployeeDto employeeDto){

        boolean passwordsMatch = employeeDto.getPassword().equals(employeeDto.getPasswordRepeat());
        if (!passwordsMatch){
            return new ErrorResult("Passwords not match");
        }

        boolean employeeExist = this.employeeService.employeeExist(employeeDto.getEmail());
        if (employeeExist){
            return new ErrorResult("Employee already exist");
        }

        boolean employeeValid = this.mernisService.validateUser(employeeDto.getIdentificationNumber());
        if (!employeeValid){
            return new ErrorResult("Identification number not valid");
        }

        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        employee.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
        employee.setBirthday(employeeDto.getBirthday());
        employee.setIdentificationNumber(employeeDto.getIdentificationNumber());

        employeeService.add(employee);

        return new SuccessResult();
    }
}
