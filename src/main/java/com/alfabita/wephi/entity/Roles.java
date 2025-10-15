package com.alfabita.wephi.entity;

import com.alfabita.wephi.dto.RolesDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles extends Common{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "slug_name")
    private String slugName;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlugName() {
        return slugName;
    }

    public void setSlugName(String slugName) {
        this.slugName = slugName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slugName='" + slugName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Roles roles = (Roles) o;
        return Objects.equals(id, roles.id) && Objects.equals(name, roles.name) && Objects.equals(slugName, roles.slugName) && Objects.equals(description, roles.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, slugName, description);
    }

    public RolesDTO toDTO() {
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setId(String.valueOf(this.id));
        rolesDTO.setName(this.name);
        rolesDTO.setSlugName(this.slugName);
        rolesDTO.setDescription(this.description);
        return rolesDTO;

    }

    public static Roles toEntity(RolesDTO rolesDTO) {
        Roles roles = new Roles();
        if(rolesDTO.getId() != null) {
            roles.setId(Long.parseLong(rolesDTO.getId()));
        }
        roles.setName(rolesDTO.getName());
        roles.setSlugName(rolesDTO.getSlugName());
        roles.setDescription(rolesDTO.getDescription());
        return roles;
    }

    public static List<Roles> toEntities(List<RolesDTO> rolesDTOS) {
        List<Roles> roles = new ArrayList<>();
        for(RolesDTO rolesDTO:rolesDTOS) {
            roles.add(toEntity(rolesDTO));
        }
        return roles;
    }

    public static List<RolesDTO> toDTOs(List<Roles> roles) {
        List<RolesDTO> rolesDTOS = new ArrayList<>();
        for(Roles role: roles) {
            rolesDTOS.add(role.toDTO());
        }
        return rolesDTOS;
    }
}
