package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;

    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody JobSeeker jobSeeker){
       return jobSeekerService.register(jobSeeker);
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> listAll(){
        return jobSeekerService.listAll();
    }
}
