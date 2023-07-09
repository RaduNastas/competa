package com.example.competa.repo;

import com.example.competa.entity.Role;
import com.example.competa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
