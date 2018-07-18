package com.rest.automation.admin.da.repository;

import com.rest.automation.admin.da.domain.OrderDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDomain,Long> {

    List<OrderDomain> findAllByStatusTrue();

    List<OrderDomain> findAllByStatusTrueAndTableTableId(int tableId);

}
