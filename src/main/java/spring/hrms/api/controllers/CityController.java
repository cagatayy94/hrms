package spring.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.business.abstracts.CityService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("getAll")
    public DataResult<List<City>> getAll(){
        return new SuccessDataResult<>(this.cityService.getAll());
    }
}
