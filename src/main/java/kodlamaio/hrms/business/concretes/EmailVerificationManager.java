package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailVerificationManager implements EmailVerificationService {
    private EmailVerificationDao emailVerificationDao;

    public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
        this.emailVerificationDao = emailVerificationDao;
    }

    @Override
    public DataResult<Optional<EmailVerification>> get(int id) {
        return new SuccessDataResult<>(emailVerificationDao.findById(id));
    }
}
