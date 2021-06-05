package spring.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.business.abstracts.LanguageService;
import spring.hrms.dataAccess.abstracts.LanguageDao;
import spring.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public void add(Language language) {
        this.languageDao.save(language);
    }
}
