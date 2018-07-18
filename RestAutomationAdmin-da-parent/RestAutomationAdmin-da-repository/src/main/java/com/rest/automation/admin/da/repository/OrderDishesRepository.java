package com.rest.automation.admin.da.repository;

import com.rest.automation.admin.da.domain.DishDomain;
import com.rest.automation.admin.da.domain.OrdersDishDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDishesRepository extends JpaRepository<OrdersDishDomain,Long> {

    @Query("select o.dish from OrdersDishDomain o where o.order.orderId =:orderId")
    List<DishDomain> findOfOrdersDishes(@Param("orderId") long orderId);

    List<OrdersDishDomain> findAllByOrderDishId(Long orderId);
}
