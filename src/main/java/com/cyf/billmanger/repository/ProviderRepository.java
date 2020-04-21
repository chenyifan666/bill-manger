package com.cyf.billmanger.repository;

import com.cyf.billmanger.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,String> {
    Provider findAllById(String id);
}
