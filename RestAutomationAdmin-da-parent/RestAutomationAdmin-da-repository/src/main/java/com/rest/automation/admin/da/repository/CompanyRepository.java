package com.rest.automation.admin.da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.automation.admin.da.domain.CompanyDomain;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDomain, Long> {

}
