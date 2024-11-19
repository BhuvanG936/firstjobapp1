package com.srsvmj.firstjobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(()-> new RuntimeException("Company does not exist with id: "+companyId));
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Company does not exist with id: "+id));

        existingCompany.setId(company.getId());
        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());

        companyRepository.save(existingCompany);
        return  true;

    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById((id))){
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}