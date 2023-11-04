package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.StaffVerification;

import java.util.Optional;

public interface StaffVerificationService {
    DataResult<Optional<StaffVerification>> get(int id);
}
