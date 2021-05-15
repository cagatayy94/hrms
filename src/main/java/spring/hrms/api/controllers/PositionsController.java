package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.business.abstracts.PositionsService;
import spring.hrms.entities.concretes.Positions;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    private PositionsService positionsService;

    @Autowired
    public PositionsController(PositionsService positionsService){
        this.positionsService = positionsService;
    }

    @GetMapping("/getAll")
    public List<Positions> getAll(){
        return this.positionsService.getAll();
    }
}
