package com.example.spd_test_task.repository;

import com.example.spd_test_task.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Long> {

 /* @Query("select p from Purchases p where p.dateOfPurchase between :y and :x")
    List<Purchases> findAllByDateRange(@Param("x")Date beginDate, @Param("y") Date endDate);

  List<Purchases>findAllByDateOfPurchaseLessThanEqualAndDateOfPurchaseGreaterThanEqual(Date endDate, Date startDate);*/
    List<Purchases>findAllByDateOfPurchaseBetween(Date endDate, Date startDate);

    /*List<Purchases>findAllByDateOfPurchaseBetweenAndUserAndId(Date endDate, Date startDate,Long id);*/
}
