package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Positions;

public interface PositionsDao extends JpaRepository<Positions, Integer> {
}
