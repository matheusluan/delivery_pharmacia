package com.ifpr.delivery_pharmacia.repositories;


import com.ifpr.delivery_pharmacia.enums.RoleName;
import com.ifpr.delivery_pharmacia.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(RoleName roleName);
}
