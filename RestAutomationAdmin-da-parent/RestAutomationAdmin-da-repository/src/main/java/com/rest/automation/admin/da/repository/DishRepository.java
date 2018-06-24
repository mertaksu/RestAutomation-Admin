package com.rest.automation.admin.da.repository;

import com.rest.automation.admin.da.domain.DishDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<DishDomain,Long> {

    List<DishDomain> findByDishName(String dishName);
}
