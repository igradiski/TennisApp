package com.hr.igradiski.app.tennis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="USER_ROLE")
@Getter
@Setter
public class UserRole extends AbstractEntity implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    @ManyToOne
    private Role role;

    @ManyToOne
    private User user;

}
