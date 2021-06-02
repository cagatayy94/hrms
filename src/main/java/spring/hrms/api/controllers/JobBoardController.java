package spring.hrms.api.controllers;

import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.CityService;
import spring.hrms.business.abstracts.EmployerService;
import spring.hrms.business.abstracts.JobBoardService;
import spring.hrms.business.abstracts.PositionService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.Result;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.entities.concretes.City;
import spring.hrms.entities.concretes.Employer;
import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.Position;
import spring.hrms.entities.concretes.dtos.JobBoardDto;

import java.util.List;

@RestController
@RequestMapping("api/jobBoard/")
public class JobBoardController {
    private final JobBoardService jobBoardService;
    private final CityService cityService;
    private final EmployerService employerService;
    private final PositionService positionService;

    public JobBoardController(JobBoardService jobBoardService, CityService cityService, EmployerService employerService, PositionService positionService) {
        this.jobBoardService = jobBoardService;
        this.cityService = cityService;
        this.employerService = employerService;
        this.positionService = positionService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobBoard>>getAll(){
        return new SuccessDataResult<>(this.jobBoardService.getAll());
    }

    @PostMapping("add")
    public Result add(@RequestBody JobBoardDto jobBoardDto){
        City city = cityService.getCityById(jobBoardDto.getCityId());
        Employer employer = this.employerService.getEmployerById(jobBoardDto.getEmployerId());
        Position position = this.positionService.getPositionById(jobBoardDto.getPositionId());

        JobBoard jobBoard = new JobBoard();
        jobBoard.setCity(city);
        jobBoard.setEmployer(employer);
        jobBoard.setPosition(position);
        jobBoard.setActive(true);
        jobBoard.setDescription(jobBoardDto.getDescription());
        jobBoard.setDueDate(jobBoardDto.getDueDate());
        jobBoard.setMaxSalary(jobBoardDto.getMaxSalary());
        jobBoard.setMinSalary(jobBoardDto.getMinSalary());
        jobBoard.setOpenPositions(jobBoardDto.getOpenPositions());

        this.jobBoardService.add(jobBoard);
        return new SuccessResult();
    }

    @PostMapping("disable")
    public Result disable(@RequestParam int jobBoardId){
        this.jobBoardService.disable(jobBoardId);
        return new SuccessResult();
    }
}
