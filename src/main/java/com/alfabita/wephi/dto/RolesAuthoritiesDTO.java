package com.alfabita.wephi.dto;

public class RolesAuthoritiesDTO {
    private Long roleId;
    private Long authorityId; //id of authorities

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
}
