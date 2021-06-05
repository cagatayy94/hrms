package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
