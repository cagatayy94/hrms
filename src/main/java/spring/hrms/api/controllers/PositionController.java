package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.business.abstracts.PositionService;
import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService){
        this.positionService = positionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Position>> getAll(){
        return this.positionService.getAll();
    }
}
