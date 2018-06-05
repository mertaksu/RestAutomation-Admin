package com.rest.automation.admin.da.repository;

import com.rest.automation.admin.da.domain.CategoryDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDomain,Long>{
}
