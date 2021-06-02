package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.JobBoard;

import java.util.List;

public interface JobBoardDao extends JpaRepository<JobBoard, Integer> {
    JobBoard getJobBoardById(int jobBoardId);
    List<JobBoard> getJobBoardByActiveTrue();
}
