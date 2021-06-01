package spring.hrms.business.abstracts;

import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.Result;
import spring.hrms.entities.concretes.Employer;
import spring.hrms.entities.concretes.dtos.EmployerDto;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    void add(Employer employer);
    boolean employerExist(String employerEmail);
}
