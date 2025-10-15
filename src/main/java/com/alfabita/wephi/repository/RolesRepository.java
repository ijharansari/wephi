package com.alfabita.wephi.repository;

import com.alfabita.wephi.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String name);
    List<Roles> findByNameIn(Set<String> names);
}
