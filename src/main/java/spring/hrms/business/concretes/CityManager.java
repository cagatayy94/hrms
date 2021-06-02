package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.CityService;
import spring.hrms.dataAccess.abstracts.CityDao;
import spring.hrms.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAll() {
        return this.cityDao.findAll();
    }

    @Override
    public City getCityById(int cityId) {
        return this.cityDao.getCityById(cityId);
    }
}
