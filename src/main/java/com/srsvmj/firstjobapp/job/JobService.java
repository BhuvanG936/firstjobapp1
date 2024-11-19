package com.srsvmj.firstjobapp.job;

import java.util.List;


public interface JobService {

    List<Job> findAllJobs();

    Job getJobById(Long id);

    Job createJob(Job job);

    Job updateJob(Long id, Job job);

    void deleteJob(Long id);

}
