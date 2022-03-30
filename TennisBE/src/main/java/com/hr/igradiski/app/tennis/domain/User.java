package com.hr.igradiski.app.tennis.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="USER_")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
public class User extends AbstractEntity implements Serializable {

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
}
