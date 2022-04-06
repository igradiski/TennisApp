package com.hr.igradiski.app.tennis.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity{

    public AbstractEntity() {
    }

    @CreatedDate
    @Column(name = "created_date")
    private Instant created;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Instant updated;

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
