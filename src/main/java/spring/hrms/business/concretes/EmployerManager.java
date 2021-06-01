package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.dataAccess.abstracts.EmployerDao;
import spring.hrms.entities.concretes.Employee;
import spring.hrms.entities.concretes.Employer;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }


    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public void add(Employer employer) {
        this.employerDao.save(employer);
    }

    @Override
    public boolean employerExist(String employerEmail) {
        List<Employer> employerExist =  this.employerDao.findByEmail(employerEmail);

        return !employerExist.isEmpty();
    }
}
