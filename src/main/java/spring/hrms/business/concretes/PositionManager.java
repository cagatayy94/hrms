package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.PositionService;
import spring.hrms.core.utilities.results.*;
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
        List<Position> positionExist =  this.positionDao.findByName(position.getName());

        if (!positionExist.isEmpty()){
            return new ErrorResult("There is another position with this name.");
        }else{
            this.positionDao.save(position);
            return new SuccessResult("Position created successfully.");
        }
    }
}
