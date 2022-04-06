package com.hr.igradiski.app.tennis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "REFRESH_TOKEN")
public class RefreshToken extends AbstractEntity implements Serializable {

    public RefreshToken() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_tok")
    @SequenceGenerator(name="seq_tok",allocationSize = 1)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(name="expire")
    private Instant expire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpire() {
        return expire;
    }

    public void setExpire(Instant expire) {
        this.expire = expire;
    }
}
