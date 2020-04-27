package com.cyf.billmanger.repository;

import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {
    @Query(value = "select new com.cyf.billmanger.dto.BillProvider(b,p) from Bill b,Provider p where b.pid = p.id")
    List<BillProvider> findBillProviders();
}
