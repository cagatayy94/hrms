package spring.hrms.business.abstracts;

import spring.hrms.entities.concretes.Positions;

import java.util.List;

public interface PositionsService {
    List<Positions> getAll();
}
