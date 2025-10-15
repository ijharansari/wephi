package com.alfabita.wephi.repository;

import com.alfabita.wephi.entity.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRoles,Long> {
    Set<UsersRoles> findByUserId(Long userId);
    UsersRoles findByUserIdAndRoleId(Long userId, Long roleId);
}
