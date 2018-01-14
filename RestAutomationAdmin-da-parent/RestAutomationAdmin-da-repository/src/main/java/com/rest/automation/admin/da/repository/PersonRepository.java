package com.rest.automation.admin.da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.automation.admin.da.domain.PersonDomain;

@Repository
public interface PersonRepository extends JpaRepository<PersonDomain, Long>{

	public PersonDomain findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
