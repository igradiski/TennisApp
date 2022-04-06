package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="USER_ROLE")
public class UserRole extends AbstractEntity implements Serializable {

    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_usr_role")
    @SequenceGenerator(name="seq_usr_role", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    @ManyToOne
    private Role role;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
