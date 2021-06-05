package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
}
