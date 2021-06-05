package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.hrms.business.abstracts.ExperienceService;
import spring.hrms.dataAccess.abstracts.ExperienceDao;
import spring.hrms.entities.concretes.Experience;

import javax.validation.Valid;

@Service
public class ExperienceManager implements ExperienceService {
    private final ExperienceDao experienceDao;

    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public void add(@Valid @RequestBody Experience experience) {
        this.experienceDao.save(experience);
    }
}
