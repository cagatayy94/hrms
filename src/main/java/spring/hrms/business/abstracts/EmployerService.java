package spring.hrms.business.abstracts;

import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
}
