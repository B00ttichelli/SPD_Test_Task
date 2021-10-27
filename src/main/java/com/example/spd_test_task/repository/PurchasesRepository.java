package com.example.spd_test_task.repository;

import com.example.spd_test_task.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases,Long> {

}
