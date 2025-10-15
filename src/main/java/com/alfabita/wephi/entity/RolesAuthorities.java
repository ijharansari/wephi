package com.alfabita.wephi.entity;

import com.alfabita.wephi.dto.RolesAuthoritiesDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles_authorities")
public class RolesAuthorities extends Common{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id") //role_id is an id in roles table
    private Long roleId;
    @Column(name = "authority_id") //authority_id is an id in authorities table
    private Long authorityId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String toString() {
        return "RolesAuthorities{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", authorityId=" + authorityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RolesAuthorities that = (RolesAuthorities) o;
        return Objects.equals(id, that.id) && Objects.equals(roleId, that.roleId) && Objects.equals(authorityId, that.authorityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, roleId, authorityId);
    }

    public RolesAuthoritiesDTO toDTO() {
        RolesAuthoritiesDTO rolesAuthoritiesDTO = new RolesAuthoritiesDTO();
        rolesAuthoritiesDTO.setRoleId(this.roleId);
        rolesAuthoritiesDTO.setAuthorityId(this.authorityId);
        return rolesAuthoritiesDTO;
    }

    public static RolesAuthorities toEntity(RolesAuthoritiesDTO rolesAuthoritiesDTO) {
        RolesAuthorities rolesAuthorities = new RolesAuthorities();
        rolesAuthorities.setAuthorityId(rolesAuthoritiesDTO.getAuthorityId());
        rolesAuthorities.setRoleId(rolesAuthoritiesDTO.getRoleId());
        return rolesAuthorities;
    }

    public static List<RolesAuthoritiesDTO> toDTOS(List<RolesAuthorities> rolesAuthorities) {
        List<RolesAuthoritiesDTO> rolesAuthoritiesDTOS = new ArrayList<>();
        for(RolesAuthorities rolesAuthority: rolesAuthorities) {
            rolesAuthoritiesDTOS.add(rolesAuthority.toDTO());
        }
        return rolesAuthoritiesDTOS;
    }

    public static List<RolesAuthorities> toEntities(List<RolesAuthoritiesDTO> rolesAuthoritiesDTOS) {
        List<RolesAuthorities> rolesAuthorities = new ArrayList<>();
        for(RolesAuthoritiesDTO rolesAuthoritiesDTO: rolesAuthoritiesDTOS) {
            rolesAuthorities.add(toEntity(rolesAuthoritiesDTO));
        }
        return rolesAuthorities;
    }

}
