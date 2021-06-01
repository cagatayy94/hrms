package spring.hrms.business.abstracts;

import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardDto;

import java.util.List;

public interface JobBoardService {
    List<JobBoard> getAll();
}
