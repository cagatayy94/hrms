package spring.hrms.api.controllers;

import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.JobBoardService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.Result;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.entities.concretes.JobBoard;
import spring.hrms.entities.concretes.dtos.JobBoardDto;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

@RestController
@RequestMapping("api/jobBoard/")
public class JobBoardController {
    private final JobBoardService jobBoardService;

    public JobBoardController(JobBoardService jobBoardService) {
        this.jobBoardService = jobBoardService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobBoard>>getAll(){
        return new SuccessDataResult<>(this.jobBoardService.getAll());
    }

    @PostMapping("add")
    public Result add(@RequestBody JobBoardDto jobBoardDto){
        return new SuccessResult();
    }
}
