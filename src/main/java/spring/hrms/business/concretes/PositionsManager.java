package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.PositionsService;
import spring.hrms.core.utilities.results.DataResult;
import spring.hrms.core.utilities.results.SuccessDataResult;
import spring.hrms.dataAccess.abstracts.PositionsDao;
import spring.hrms.entities.concretes.Positions;

import java.util.List;

@Service
public class PositionsManager implements PositionsService {

    private final PositionsDao positionsDao;

    @Autowired
    public PositionsManager(PositionsDao positionsDao){
        this.positionsDao = positionsDao;
    }

    @Override
    public DataResult<List<Positions>> getAll() {
        return new SuccessDataResult<>(this.positionsDao.findAll(), "Positions listed successfully.");
    }
}
