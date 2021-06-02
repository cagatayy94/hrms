package spring.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
    City getCityById(int cityId);
}
