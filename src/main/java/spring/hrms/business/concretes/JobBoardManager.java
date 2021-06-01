package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.hrms.business.abstracts.JobBoardService;
import spring.hrms.core.utilities.results.Result;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.dataAccess.abstracts.JobBoardDao;
import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardDto;

import java.util.List;

@Service
public class JobBoardManager implements JobBoardService {

    private final JobBoardDao jobBoardDao;

    public JobBoardManager(JobBoardDao jobBoardDao) {
        this.jobBoardDao = jobBoardDao;
    }

    @Override
    public List<JobBoard> getAll() {
        return jobBoardDao.findAll();
    }
}
