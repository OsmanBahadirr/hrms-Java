package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.StaffVerificationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.StaffVerificationDao;
import kodlamaio.hrms.entities.concretes.StaffVerification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffVerificationManager implements StaffVerificationService {
    private StaffVerificationDao staffVerificationDao;

    @Override
    public DataResult<Optional<StaffVerification>> get(int id) {
        return new SuccessDataResult<>(staffVerificationDao.findById(id));
    }
}
