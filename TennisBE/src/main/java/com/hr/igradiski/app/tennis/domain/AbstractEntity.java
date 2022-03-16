package com.hr.igradiski.app.tennis.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractEntity extends AbstractPersistable {

    @CreatedDate
    @Column(name = "created_date")
    private Instant created;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Instant updated;

}
