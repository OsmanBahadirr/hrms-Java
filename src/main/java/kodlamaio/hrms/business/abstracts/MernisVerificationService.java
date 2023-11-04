package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.MernisVerification;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MernisVerificationService {
    DataResult<Optional<MernisVerification>> get(int id);
}
