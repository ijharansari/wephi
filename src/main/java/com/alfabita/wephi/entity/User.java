package com.alfabita.wephi.entity;

import com.alfabita.wephi.dto.UsersDTO;
import com.alfabita.wephi.enums.UserType;
import com.alfabita.wephi.utils.UserUtils;
import jakarta.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "ambassador_code")
    private String ambassadorCode;
    @Column(name = "phone")
    private String phone;
    @Column(name = "emergency_contact")
    private String emergencyContact;
    @Column(name = "last_password_changed_on")
    private LocalDateTime lastPasswordChangedOn;

    @Column(name = "user_type")
    private String userType;
    @Column(name = "last_successful_logged_on")
    private LocalDateTime lastSuccessfulLoggedOn;
    @Column(name = "last_unsuccessful_logged_on")
    private LocalDateTime lastUnsuccessfulLoggedOn;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_credential_expired")
    private Boolean isCredentialExpired;

    @Column(name = "country")
    private String country;

    @Transient
    private Set<SimpleGrantedAuthority> authorities;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(middleName, user.middleName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(ambassadorCode, user.ambassadorCode) && Objects.equals(phone, user.phone) && Objects.equals(emergencyContact, user.emergencyContact) && Objects.equals(lastPasswordChangedOn, user.lastPasswordChangedOn) && Objects.equals(userType, user.userType) && Objects.equals(lastSuccessfulLoggedOn, user.lastSuccessfulLoggedOn) && Objects.equals(lastUnsuccessfulLoggedOn, user.lastUnsuccessfulLoggedOn) && Objects.equals(isActive, user.isActive) && Objects.equals(isCredentialExpired, user.isCredentialExpired) && Objects.equals(country, user.country) && Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, middleName, lastName, username, email, password, ambassadorCode, phone, emergencyContact, lastPasswordChangedOn, userType, lastSuccessfulLoggedOn, lastUnsuccessfulLoggedOn, isActive, isCredentialExpired, country, authorities);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ambassadorCode='" + ambassadorCode + '\'' +
                ", phone='" + phone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", lastPasswordChangedOn=" + lastPasswordChangedOn +
                ", userType='" + userType + '\'' +
                ", lastSuccessfulLoggedOn=" + lastSuccessfulLoggedOn +
                ", lastUnsuccessfulLoggedOn=" + lastUnsuccessfulLoggedOn +
                ", isActive=" + isActive +
                ", isCredentialExpired=" + isCredentialExpired +
                ", country='" + country + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public UsersDTO toDTO() {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(this.id);
        usersDTO.setFirstName(this.firstName);
        usersDTO.setMiddleName(this.middleName);
        usersDTO.setLastName(this.lastName);
        usersDTO.setUsername(this.username);
        usersDTO.setEmail(this.email);
        usersDTO.setPassword(this.password);
        usersDTO.setAmbassadorCode(this.ambassadorCode);
        usersDTO.setPhone(this.phone);
        usersDTO.setEmergencyContact(this.emergencyContact);
        usersDTO.setLastPasswordChangedOn(this.lastPasswordChangedOn);
        usersDTO.setUserType(this.userType);
        usersDTO.setLastSuccessfulLoggedOn(this.lastSuccessfulLoggedOn);
        usersDTO.setLastUnsuccessfulLoggedOn(this.lastUnsuccessfulLoggedOn);
        usersDTO.setActive(this.isActive);
        usersDTO.setCredentialExpired(this.isCredentialExpired);
        usersDTO.setCountryCode(this.country);
        return usersDTO;
    }
    
    public static User toEntity(UsersDTO usersDTO) {
        User user = new User();
        user.setId(usersDTO.getId());
        user.setFirstName(usersDTO.getFirstName());
        user.setMiddleName(usersDTO.getMiddleName());
        user.setLastName(usersDTO.getLastName());
        user.setUsername(usersDTO.getUsername());
        user.setEmail(usersDTO.getEmail());
        user.setPassword(usersDTO.getPassword());
        user.setAmbassadorCode(usersDTO.getAmbassadorCode());
        user.setPhone(usersDTO.getPhone());
        user.setEmergencyContact(usersDTO.getEmergencyContact());
        user.setLastPasswordChangedOn(usersDTO.getLastPasswordChangedOn());
        user.setUserType(usersDTO.getUserType());
        user.setLastSuccessfulLoggedOn(usersDTO.getLastSuccessfulLoggedOn());
        user.setLastUnsuccessfulLoggedOn(usersDTO.getLastUnsuccessfulLoggedOn());
        user.setActive(usersDTO.getActive());
        user.setCredentialExpired(usersDTO.getCredentialExpired());
        user.setCountry(usersDTO.getCountryCode());
        return user;
    }

    public static List<UsersDTO> toDTOs(List<User> users) {
        List<UsersDTO> usersDTOS = new ArrayList<>();
        for(User user: users) {
            usersDTOS.add(user.toDTO());
        }
        return usersDTOS;
    }

    public static List<User> toEntities(List<UsersDTO> usersDTOS) {
        List<User> users = new ArrayList<>();
        for(UsersDTO usersDTO: usersDTOS) {
            users.add(toEntity(usersDTO));
        }
        return users;
    }

    public static boolean isDemoUser() {
        User user = UserUtils.getCurrentLoginUser();
        assert user != null;
        return UserType.DEMO_USER.name().equals(user.getUserType());
    }
    public static boolean isExternalUser() {
        User user = UserUtils.getCurrentLoginUser();
        assert user != null;
        return UserType.EXTERNAL.name().equals(user.getUserType());
    }
    public static boolean isResellerUser() {
        User user = UserUtils.getCurrentLoginUser();
        assert user != null;
        return UserType.RESELLER.name().equals(user.getUserType());
    }
}
