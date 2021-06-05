package spring.hrms.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployeeService;
import spring.hrms.business.abstracts.LanguageService;
import spring.hrms.core.utilities.results.ErrorDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.entities.concretes.Language;
import spring.hrms.entities.concretes.dtos.LanguageDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/language/")
public class LanguageController {
    private final LanguageService languageService;
    private final EmployeeService employeeService;

    public LanguageController(LanguageService languageService, EmployeeService employeeService) {
        this.languageService = languageService;
        this.employeeService = employeeService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageDto languageDto){

        Language language = new Language();

        language.setLevel(languageDto.getLevel());
        language.setName(languageDto.getName());
        language.setEmployee(this.employeeService.getEmployeeById(languageDto.getUserId()));

        this.languageService.add(language);
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
