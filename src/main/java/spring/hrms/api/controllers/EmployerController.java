package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.entities.concretes.Employer;
import java.util.List;

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
        return this.employerService.getAll();
    }
}
