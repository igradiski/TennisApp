package com.hr.igradiski.app.tennis.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROLE")
public class Role extends AbstractEntity implements Serializable {

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_role")
    @SequenceGenerator(name="seq_role",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @OneToMany(mappedBy="role")
    private List<UserRole> userRoles;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
