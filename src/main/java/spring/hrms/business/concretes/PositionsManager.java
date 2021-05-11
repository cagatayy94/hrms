package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.PositionsService;
import spring.hrms.dataAccess.abstracts.PositionsDao;
import spring.hrms.entities.concretes.Positions;

import java.util.List;

@Service
public class PositionsManager implements PositionsService {

    private PositionsDao positionsDao;

    @Autowired
    public PositionsManager(PositionsDao positionsDao){
        this.positionsDao = positionsDao;
    }

    @Override
    public List<Positions> getAll() {
        return this.positionsDao.findAll();
    }
}
