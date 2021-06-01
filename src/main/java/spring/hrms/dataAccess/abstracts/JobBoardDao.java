package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.JobBoard;

public interface JobBoardDao extends JpaRepository<JobBoard, Integer> {
}
