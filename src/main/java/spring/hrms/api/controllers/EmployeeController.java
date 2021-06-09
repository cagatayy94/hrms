package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.business.abstracts.MernisService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Employee;
import spring.hrms.entities.concretes.dtos.EmployeeDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
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
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeDto employeeDto){

        boolean passwordsMatch = employeeDto.getPassword().equals(employeeDto.getPasswordRepeat());
        if (!passwordsMatch){
            return ResponseEntity.ok(new ErrorResult("Passwords not match"));
        }

        boolean employeeExist = this.employeeService.employeeExist(employeeDto.getEmail());
        if (employeeExist){
            return ResponseEntity.ok(new ErrorResult("Employee already exist"));
        }

        boolean employeeValid = this.mernisService.validateUser(employeeDto.getIdentificationNumber());
        if (!employeeValid){
            return ResponseEntity.ok(new ErrorResult("Identification number not valid"));
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

        return ResponseEntity.ok(new SuccessResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors, "Doğrulama Hataları");
        return errors;
    }
}
