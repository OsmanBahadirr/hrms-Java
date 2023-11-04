package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;

import java.util.Optional;

public interface EmailVerificationService {
     DataResult<Optional<EmailVerification>> get(int id);
}
