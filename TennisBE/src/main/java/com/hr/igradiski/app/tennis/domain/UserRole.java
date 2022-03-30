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

}
