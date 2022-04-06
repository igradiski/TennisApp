package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="USER_")
public class User extends AbstractEntity implements Serializable {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_usr")
    @SequenceGenerator(name="seq_usr",allocationSize = 1)
    @Column(name="id")
    private Long id;

    private Boolean active;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_LOGIN")
    private Date lastLogin;

    private String name;

    private String password;

    private String surname;

    private String username;

    @OneToMany(mappedBy = "user")
    private Set<RefreshToken> refreshToken;

    @OneToMany(mappedBy="user")
    private List<UserRole> userRoles;

    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<RefreshToken> getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(Set<RefreshToken> refreshToken) {
        this.refreshToken = refreshToken;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
