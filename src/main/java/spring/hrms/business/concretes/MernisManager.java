package spring.hrms.business.concretes;

import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.MernisService;

import java.util.Random;

@Service
public class MernisManager implements MernisService {

    @Override
    public boolean validateUser(String identificationNumber) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
