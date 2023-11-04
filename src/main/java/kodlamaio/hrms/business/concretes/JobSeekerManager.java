package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisVerificationService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.MernisVerificationDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private MernisVerificationService mernisVerificationService;
    private EmailVerificationService emailVerificationService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisVerificationService mernisVerificationService, EmailVerificationService emailVerificationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisVerificationService = mernisVerificationService;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public Result register(JobSeeker jobSeeker) {

        if(
                jobSeeker.getName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getNationalId().isEmpty() || jobSeeker.getBirtyYear().isEmpty()
                || jobSeeker.getEmail().isEmpty() || jobSeeker.getPassword().isEmpty() || jobSeeker.getPasswordVerification().isEmpty()
        ){
            return new ErrorResult("Fields cannot be empty");
        }

        var email = findFirstByEmail(jobSeeker.getEmail());

        if( !email.isSuccess()){
           return new ErrorResult(email.getMessage());
        }

        var nationalId = findFirstByNationalId(jobSeeker.getNationalId());

        if (!nationalId.isSuccess()){
            return new ErrorResult(nationalId.getMessage());
        }

        if (!mernisVerificationService.get(jobSeeker.getId()).getData().get().isSuccess()){
            return new ErrorResult("Mernis verification error");
        }

        if (!emailVerificationService.get(jobSeeker.getId()).getData().get().isSuccess()){
            return new ErrorResult("Email verification error");
        }

        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeeker>> findFirstByEmail(String Email) {
        var jobSeeker = jobSeekerDao.findFirstByEmail(Email);
        var isEmpty = jobSeeker.isEmpty();
        if (!isEmpty){
            return new ErrorDataResult<>("Email exists",jobSeeker);
        }
        return new SuccessDataResult<>(null);
    }

    @Override
    public DataResult<List<JobSeeker>> findFirstByNationalId(String NationalId) {
       var jobSeeker = jobSeekerDao.findFirstByNationalId(NationalId);
       var isEmpty = jobSeeker.isEmpty();
       if (!isEmpty){
           return new ErrorDataResult<>("National Id exists",jobSeeker);
       }
       return new SuccessDataResult<>(null);
    }

    @Override
    public DataResult<List<JobSeeker>> listAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll());
    }
}
