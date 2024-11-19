package com.srsvmj.firstjobapp.company;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();


    Company getCompanyById(Long id);


    Company createCompany(Company company);

    boolean updateCompany(Company company, Long id);

    boolean deleteCompanyById(Long id);
}
