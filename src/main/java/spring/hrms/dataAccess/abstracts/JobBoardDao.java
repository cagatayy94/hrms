package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardListDto;

import java.util.Date;
import java.util.List;

public interface JobBoardDao extends JpaRepository<JobBoard, Integer> {
    JobBoard getJobBoardById(int jobBoardId);
    List<JobBoard> getJobBoardByActiveTrue();

    @Query("Select new spring.hrms.entities.concretes.dtos.JobBoardListDto" +
            "(jb.id,jb.employer.companyName, jb.position.name, jb.openPositions, jb.createdAt, jb.dueDate)" +
            " From JobBoard jb")
    List<JobBoardListDto> getJobBoardsByListDto();
}
