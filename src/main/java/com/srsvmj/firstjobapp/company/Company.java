package com.srsvmj.firstjobapp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srsvmj.firstjobapp.job.Job;
import com.srsvmj.firstjobapp.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // One Company has Many jobs
    @JsonIgnore //it will remove the recursive call backs
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    //it will remove the recursive call backs
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}
