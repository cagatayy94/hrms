package spring.hrms.business.abstracts;

import spring.hrms.core.utilities.results.*;
import spring.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getAll();
    Result add(Position position);
}
