package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Employer;
import spring.hrms.entities.concretes.dtos.EmployerDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/employers/")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("getAll")
    public DataResult<List<Employer>> getAll(){
        return new SuccessDataResult<>(this.employerService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody EmployerDto employerDto){

        if (!employerDto.getPassword().equals(employerDto.getPasswordRepeat())){
            return ResponseEntity.ok(new ErrorResult("Passwords not match"));
        }

        String[] webSiteParts = employerDto.getWebsite().split("\\.");
        String webSiteDomain = webSiteParts[webSiteParts.length-2];
        String emailDomain = "";

        Pattern pattern = Pattern.compile("(?<=@)[^.]+(?=\\.)");
        Matcher matcher = pattern.matcher(employerDto.getEmail());

        if (matcher.find()){
            emailDomain = matcher.group();
        }

        if (!emailDomain.equals(webSiteDomain)){
            return ResponseEntity.ok(new ErrorResult("Email and website domains not match"));
        }

        boolean employerExist = this.employerService.employerExist(employerDto.getEmail());

        if (employerExist){
            return ResponseEntity.ok(new ErrorResult("There is another record with this email"));
        }


        Employer employer = new Employer();
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setMobile(employerDto.getMobile());
        employer.setEmail(employerDto.getEmail());
        employer.setWebSite(employerDto.getWebsite());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        employer.setPassword(bCryptPasswordEncoder.encode(employerDto.getPassword()));

        this.employerService.add(employer);

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
