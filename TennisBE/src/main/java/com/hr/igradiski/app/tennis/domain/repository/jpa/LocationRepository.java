package com.hr.igradiski.app.tennis.domain.repository.jpa;

import com.hr.igradiski.app.tennis.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
