package com.srsvmj.firstjobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    //1. Find All Jobs REST API
    @GetMapping
    public ResponseEntity<List<Job>> findAllJobs(){

        List<Job> jobs =  jobService.findAllJobs();

        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    //2. Find Job By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job = jobService.getJobById(id);

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    //3. create New Job REST API
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        Job createdJob = jobService.createJob(job);

        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    //4. Update Job, REST API
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job){

        Job uodatedJob = jobService.updateJob(id, job);

        return new ResponseEntity<>(uodatedJob, HttpStatus.OK);
    }

    //5. Delete Job REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);

        return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.NOT_FOUND);
    }
}
