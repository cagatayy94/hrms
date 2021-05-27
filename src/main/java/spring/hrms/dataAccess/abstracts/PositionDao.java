package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionDao extends JpaRepository<Position, Integer> {
    List<Position> findByName(String name);
}
