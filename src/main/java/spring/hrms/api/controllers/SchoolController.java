package spring.hrms.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.business.abstracts.SchoolService;
import spring.hrms.core.utilities.results.ErrorDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.entities.concretes.School;
import spring.hrms.entities.concretes.dtos.SchoolDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/schools/")
public class SchoolController {
    private final SchoolService schoolService;
    private final EmployeeService employeeService;

    public SchoolController(SchoolService schoolService, EmployeeService employeeService) {
        this.schoolService = schoolService;
        this.employeeService = employeeService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid SchoolDto schoolDto){

        School school = new School();
        school.setDepartment(schoolDto.getDepartment());
        school.setEndYear(schoolDto.getEndYear());
        school.setName(schoolDto.getName());
        school.setStartYear(schoolDto.getStartYear());
        school.setEmployee(this.employeeService.getEmployeeById(schoolDto.getUserId()));

        this.schoolService.add(school);
        return ResponseEntity.ok(new SuccessResult("Added"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "Doğrulama Hataları");
    }
}
