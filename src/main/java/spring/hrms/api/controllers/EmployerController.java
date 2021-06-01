package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Employer;
import spring.hrms.entities.concretes.dtos.EmployerDto;
import java.util.List;
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
    public Result add(@RequestBody EmployerDto employerDto){

        if (employerDto.getEmail() == null || employerDto.getEmail().isBlank()){
            return new ErrorResult("Email required");
        }

        if (employerDto.getPasswordRepeat() == null || employerDto.getPassword() == null || employerDto.getPassword().isBlank() || employerDto.getPassword().isBlank()){
            return new ErrorResult("Password required");
        }

        if (!employerDto.getPassword().equals(employerDto.getPasswordRepeat())){
            return new ErrorResult("Passwords not match");
        }

        if (employerDto.getMobile() == null || employerDto.getMobile().isBlank()){
            return new ErrorResult("Mobile required");
        }

        if (employerDto.getWebsite() == null ||employerDto.getWebsite().isBlank()){
            return new ErrorResult("Website required");
        }

        if (employerDto.getCompanyName() == null || employerDto.getCompanyName().isBlank()){
            return new ErrorResult("Company name required");
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
            return new ErrorResult("Email and website domains not match");
        }

        boolean employerExist = this.employerService.employerExist(employerDto.getEmail());

        if (employerExist){
            return new ErrorResult("There is another record with this email");
        }


        Employer employer = new Employer();
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setMobile(employerDto.getMobile());
        employer.setEmail(employerDto.getEmail());
        employer.setWebSite(employerDto.getWebsite());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        employer.setPassword(bCryptPasswordEncoder.encode(employerDto.getPassword()));

        this.employerService.add(employer);

        return new SuccessResult();
    }
}
