package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.business.abstracts.ExperienceService;
import spring.hrms.core.utilities.results.ErrorDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.entities.concretes.Experience;
import spring.hrms.entities.concretes.dtos.ExperienceDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/experience/")
public class ExperienceController {
    private final ExperienceService experienceService;
    private final EmployeeService employeeService;

    @Autowired
    public ExperienceController(ExperienceService experienceService, EmployeeService employeeService) {
        this.experienceService = experienceService;
        this.employeeService = employeeService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody ExperienceDto experienceDto){
        Experience experience = new Experience();

        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setEndYear(experienceDto.getEndYear());
        experience.setStartYear(experienceDto.getStartYear());
        experience.setPosition(experienceDto.getPosition());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setEmployee(this.employeeService.getEmployeeById(experienceDto.getUserId()));
        
        this.experienceService.add(experience);
        return ResponseEntity.ok(new SuccessResult("added"));
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
