package com.example.composite.controller;

import com.example.composite.model.Company;
import com.example.composite.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Company saveCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }
}
