package com.cyf.billmanger.repository;

import com.cyf.billmanger.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleById(Long id);
}
