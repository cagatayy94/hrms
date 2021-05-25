package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.hrms.business.abstracts.PositionService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService){
        this.positionService = positionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Position>> getAll(){
        return this.positionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Position position){
        return this.positionService.add(position);
    }
}
