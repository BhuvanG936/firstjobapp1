package com.srsvmj.firstjobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAllJobs() {

        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Job Not Found with id: "+id));
    }

    @Override
    public Job createJob(Job job){

        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Job existingJob = jobRepository.findById(id).orElseThrow(()-> new RuntimeException("Job Not found with id: "+id));

        existingJob.setId(job.getId());
        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());

        return jobRepository.save(existingJob);
    }

    @Override
    public void deleteJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Job Not Found with id: "+id));

        if(jobRepository.existsById(id)){
            jobRepository.deleteById(job.getId());
        }
    }
}
