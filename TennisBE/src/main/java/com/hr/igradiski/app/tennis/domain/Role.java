package com.hr.igradiski.app.tennis.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROLE")
@Getter
@Setter
public class Role extends AbstractEntity implements Serializable {

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

}
