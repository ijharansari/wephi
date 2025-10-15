package com.alfabita.wephi.entity;

import com.alfabita.wephi.security.UserDetailsImpl;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Common {
    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;
    @LastModifiedBy
    @Column(name = "updated_by")
    private Long updatedBy;
    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @LastModifiedDate
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void onPrePersist(){
        String strUserId = getCurrentUserId();
        if(!StringUtils.hasText(strUserId)) {
            strUserId = "-1";
        }

        this.createdBy = Long.parseLong(strUserId);
        this.updatedBy = Long.parseLong(strUserId);
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        String strUserId = getCurrentUserId();
        if(!StringUtils.hasText(strUserId)) {
            strUserId = "-1";
        }
        this.updatedBy = Long.parseLong(strUserId);
        this.updatedOn = LocalDateTime.now();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Common{" +
                "createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Common common = (Common) o;
        return Objects.equals(createdBy, common.createdBy) && Objects.equals(updatedBy, common.updatedBy) && Objects.equals(createdOn, common.createdOn) && Objects.equals(updatedOn, common.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, updatedBy, createdOn, updatedOn);
    }

    private String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null == authentication) {
            return "-2";
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            Long userId = ((UserDetailsImpl)principal).getId();
            return String.valueOf(userId);
        }
        return "-1";
    }
}
