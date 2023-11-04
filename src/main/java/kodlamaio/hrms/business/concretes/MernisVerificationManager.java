package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.MernisVerificationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.MernisVerificationDao;
import kodlamaio.hrms.entities.concretes.MernisVerification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MernisVerificationManager implements MernisVerificationService {

    private MernisVerificationDao mernisVerificationDao;

    public MernisVerificationManager(MernisVerificationDao mernisVerificationDao) {
        this.mernisVerificationDao = mernisVerificationDao;
    }

    @Override
    public DataResult<Optional<MernisVerification>> get(int id) {
        var result = mernisVerificationDao.findById(id);
        return new SuccessDataResult<>(result);
    }
}
