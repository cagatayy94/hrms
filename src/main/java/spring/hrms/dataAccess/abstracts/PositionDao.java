package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
}
