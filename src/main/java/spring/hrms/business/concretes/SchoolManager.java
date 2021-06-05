package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.SchoolService;
import spring.hrms.dataAccess.abstracts.SchoolDao;
import spring.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public void add(School school) {
        this.schoolDao.save(school);
    }
}
