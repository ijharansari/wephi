package com.alfabita.wephi.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class UsersDTO {
    private Long id;
    private String firstName; //mandatory
    private String middleName;
    private String lastName; //mandatory
    private String username;
    private String email; //mandatory
    private String password; //mandatory
    private String ambassadorCode;
    private String phone; //mandatory
    private String emergencyContact;
    private LocalDateTime lastPasswordChangedOn;
    private LocalDateTime lastSuccessfulLoggedOn;
    private LocalDateTime lastUnsuccessfulLoggedOn;
    private Boolean isActive;
    private Boolean isCredentialExpired;
    private Set<String> roles; //mandatory
    private String userCode; //this denote the code of user like ambassador code
    private String countryCode;
    private String roleName;
    private String userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAmbassadorCode() {
        return ambassadorCode;
    }

    public void setAmbassadorCode(String ambassadorCode) {
        this.ambassadorCode = ambassadorCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDateTime getLastPasswordChangedOn() {
        return lastPasswordChangedOn;
    }

    public void setLastPasswordChangedOn(LocalDateTime lastPasswordChangedOn) {
        this.lastPasswordChangedOn = lastPasswordChangedOn;
    }

    public LocalDateTime getLastSuccessfulLoggedOn() {
        return lastSuccessfulLoggedOn;
    }

    public void setLastSuccessfulLoggedOn(LocalDateTime lastSuccessfulLoggedOn) {
        this.lastSuccessfulLoggedOn = lastSuccessfulLoggedOn;
    }

    public LocalDateTime getLastUnsuccessfulLoggedOn() {
        return lastUnsuccessfulLoggedOn;
    }

    public void setLastUnsuccessfulLoggedOn(LocalDateTime lastUnsuccessfulLoggedOn) {
        this.lastUnsuccessfulLoggedOn = lastUnsuccessfulLoggedOn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getCredentialExpired() {
        return isCredentialExpired;
    }

    public void setCredentialExpired(Boolean credentialExpired) {
        isCredentialExpired = credentialExpired;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
