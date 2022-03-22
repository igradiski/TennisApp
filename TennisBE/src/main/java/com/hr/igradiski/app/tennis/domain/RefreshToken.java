package com.hr.igradiski.app.tennis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "REFRESH_TOKEN")
@Data
@NoArgsConstructor
public class RefreshToken extends AbstractEntity implements Serializable {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(name="expire")
    private Instant expire;
}
