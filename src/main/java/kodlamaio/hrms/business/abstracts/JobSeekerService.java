package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import javax.xml.crypto.Data;
import java.util.List;

public interface JobSeekerService {
    Result register(JobSeeker jobSeeker);
    DataResult<List<JobSeeker>> findFirstByEmail(String Email);
    DataResult<List<JobSeeker>> findFirstByNationalId(String NationalId);
    DataResult<List<JobSeeker>> listAll();
}
