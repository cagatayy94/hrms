package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.PositionService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.Result;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.core.utilities.results.SuccessResult;
import spring.hrms.dataAccess.abstracts.PositionDao;
import spring.hrms.entities.concretes.Position;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    private final PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao){
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<>(this.positionDao.findAll(), "Positions listed successfully.");
    }

    @Override
    public Result add(Position position) {
        this.positionDao.save(position);
        return new SuccessResult("Position created successfully.");
    }
}
