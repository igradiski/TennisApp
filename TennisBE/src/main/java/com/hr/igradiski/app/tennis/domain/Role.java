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

    @OneToMany(mappedBy="role")
    private List<UserRole> userRoles;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
