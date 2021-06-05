package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.SkillService;
import spring.hrms.dataAccess.abstracts.SkillDao;
import spring.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

    private final SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public void add(Skill skill) {
        this.skillDao.save(skill);
    }
}
