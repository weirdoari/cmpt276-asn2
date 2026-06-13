package com.cmpt276_cs_prof_rate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmpt276_cs_prof_rate.demo.models.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByName(String name);
    List<Users> findByRoleType(String roleType);
    boolean existsByName(String name);

}
 