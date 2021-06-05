package spring.hrms.business.abstracts;

import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardDto;
import spring.hrms.entities.concretes.dtos.JobBoardListDto;

import java.util.List;

public interface JobBoardService {
    List<JobBoard> getAll();
    List<JobBoardListDto> getAllWithDto();
    void add(JobBoard jobBoard);
    void disable(int jobBoardId);
}
