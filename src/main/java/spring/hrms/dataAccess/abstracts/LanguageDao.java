package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
