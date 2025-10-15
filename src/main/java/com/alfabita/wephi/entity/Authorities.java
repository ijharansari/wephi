package com.alfabita.wephi.entity;

import com.alfabita.wephi.dto.AuthoritiesDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authorities extends Common{
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
        return "Authorities{" +
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
        Authorities that = (Authorities) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(slugName, that.slugName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, slugName, description);
    }

    public AuthoritiesDTO toDTO() {
        AuthoritiesDTO authoritiesDTO = new AuthoritiesDTO();
        authoritiesDTO.setId(this.id);
        authoritiesDTO.setName(this.name);
        authoritiesDTO.setSlugName(this.slugName);
        authoritiesDTO.setDescription(this.description);
        return authoritiesDTO;

    }

    public static Authorities toEntity(AuthoritiesDTO authoritiesDTO) {
        Authorities authorities = new Authorities();
        if(authoritiesDTO.getId() != null) {
            authorities.setId(authoritiesDTO.getId());
        }
        authorities.setName(authoritiesDTO.getName());
        authorities.setSlugName(authoritiesDTO.getSlugName());
        authorities.setDescription(authoritiesDTO.getDescription());
        return authorities;
    }

    public static List<Authorities> toEntities(List<AuthoritiesDTO> authoritiesDTOS) {
        List<Authorities> authorities = new ArrayList<>();
        for(AuthoritiesDTO authoritiesDTO:authoritiesDTOS) {
            authorities.add(toEntity(authoritiesDTO));
        }
        return authorities;
    }

    public static List<AuthoritiesDTO> toDTOs(List<Authorities> authorities) {
        List<AuthoritiesDTO> authoritiesDTOS = new ArrayList<>();
        for(Authorities authority: authorities) {
            authoritiesDTOS.add(authority.toDTO());
        }
        return authoritiesDTOS;
    }
}

