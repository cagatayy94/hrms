package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.JobBoardService;
import spring.hrms.dataAccess.abstracts.CityDao;
import spring.hrms.dataAccess.abstracts.JobBoardDao;
import spring.hrms.entities.concretes.City;
import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardListDto;

import java.util.List;

@Service
public class JobBoardManager implements JobBoardService {

    private final JobBoardDao jobBoardDao;

    public JobBoardManager(JobBoardDao jobBoardDao, CityDao cityDao) {
        this.jobBoardDao = jobBoardDao;
    }

    @Override
    public List<JobBoard> getAll() {
        return jobBoardDao.getJobBoardByActiveTrue();
    }

    @Override
    public List<JobBoardListDto> getAllWithDto() {
        return this.jobBoardDao.getJobBoardsByListDto();
    }

    @Override
    public void add(JobBoard jobBoard) {
        this.jobBoardDao.save(jobBoard);
    }

    @Override
    public void disable(int jobBoardId) {
        JobBoard jobBoard = this.jobBoardDao.getJobBoardById(jobBoardId);
        jobBoard.setActive(false);
        this.jobBoardDao.save(jobBoard);
    }
}
