package com.example.spd_test_task.repository;

import com.example.spd_test_task.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Long> {

    List<Purchases>findAllByDateOfPurchaseBetween(Date endDate, Date startDate);
}
