package spring.hrms.business.abstracts;

import spring.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    List<City> getAll();
    City getCityById(int cityId);
}
