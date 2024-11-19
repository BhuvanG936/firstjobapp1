package com.srsvmj.firstjobapp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srsvmj.firstjobapp.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
