package com.amani.backend.service;

import com.amani.backend.entity.Company;
import com.amani.backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //annotation lets Spring know that this is a service class and makes it available for injection. This allows you to easily use it from your UI code later on
public class CompanyService {

  private CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<Company> findAll() {
    return companyRepository.findAll();
  }

  public Map<String, Integer> getStats() {
	  HashMap<String, Integer> stats = new HashMap<>();
	  findAll().forEach(company -> stats.put(company.getName(), company.getEmployees().size())); // 
	  return stats;
	}

}