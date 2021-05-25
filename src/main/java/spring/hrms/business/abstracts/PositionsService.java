package spring.hrms.business.abstracts;

import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.entities.concretes.Positions;

import java.util.List;

public interface PositionsService {
    DataResult<List<Positions>> getAll();
}
