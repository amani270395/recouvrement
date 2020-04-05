package com.amani.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amani.backend.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
