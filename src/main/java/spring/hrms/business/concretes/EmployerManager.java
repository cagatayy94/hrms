package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.dataAccess.abstracts.EmployerDao;
import spring.hrms.entities.concretes.Employer;
import spring.hrms.entities.concretes.dtos.EmployerDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }


    @Override
    public List<EmployerDto> getAll() {
        List<Employer> employers = this.employerDao.findAll();
        List<EmployerDto> employersDtos = new ArrayList<>();
        employers.forEach(item -> {
            EmployerDto employerDto = new EmployerDto();
            employerDto.setEmail(item.getEmail());
            employerDto.setCompany_name(item.getCompany_name());
            employerDto.setEmail_approved(item.isEmail_approved());
            employerDto.setMobile(item.getMobile());
            employerDto.setEmployerApproved(item.isEmployerApproved());
            employerDto.setWeb_site(item.getWeb_site());
            employerDto.setCompany_name(item.getCompany_name());
            employersDtos.add(employerDto);
        });

        return employersDtos;
    }
}
