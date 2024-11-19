package com.srsvmj.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //1. To Retrieve All the Companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){

        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    //2. To Retrieve Company based on Id passed
    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){

        Company company = companyService.getCompanyById(id);

        return new ResponseEntity<>(company, HttpStatus.OK);
    }


    //3. To Create new Company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company createdCompany =  companyService.createCompany(company);

        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        boolean isUpdated = companyService.updateCompany(company,id);

        if(isUpdated)
            return new ResponseEntity<>("Company Updated Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Company Not Updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){

        boolean isCompanyDeleted = companyService.deleteCompanyById(id);

        if(isCompanyDeleted)
            return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Company Not Deleted",HttpStatus.NOT_FOUND);
    }
}
