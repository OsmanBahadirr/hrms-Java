package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.StaffVerificationService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private StaffVerificationService staffVerificationService;
    private EmailVerificationService emailVerificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, StaffVerificationService staffVerificationService, EmailVerificationService emailVerificationService) {
        this.employerDao = employerDao;
        this.staffVerificationService= staffVerificationService;
        this.emailVerificationService= emailVerificationService;
    }

    @Override
    public DataResult<List<Employer>> listAll() {
        return new SuccessDataResult<>(employerDao.findAll());
    }

    @Override
    public Result register(Employer employer) {

        if (employer.getCompanyName().isEmpty() || employer.getWebSite().isEmpty() || employer.getEmail().isEmpty()
        || employer.getPhone().isEmpty() || employer.getPassword().isEmpty() || employer.getPasswordVerfication().isEmpty()
        ) {
           return new ErrorResult("Fields cannot be null");
        }

        String[] parts = employer.getEmail().split("@");
        String domain = parts[1];
        if (!domain.equals(employer.getWebSite())){
            return new ErrorResult("The email must have the web site");
        }

        var email = findFirstByEmail(employer.getEmail());

        if (!email.isSuccess()){
            return new ErrorDataResult<>(email.getMessage());
        }

        if (!staffVerificationService.get(employer.getId()).getData().get().isSuccess()){
            return new ErrorResult("Staff verification error");
        }
        if (!emailVerificationService.get(employer.getId()).getData().get().isSuccess()){
            return new ErrorResult("Email verification error");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Employer>> findFirstByEmail(String Email) {
        var employer = employerDao.findFirstByEmail(Email);
        var isEmpty = employer.isEmpty();
        if (!isEmpty){
            return new ErrorDataResult<>("Email exists",employer);
        }
        return new SuccessDataResult<>(null);
    }

}
