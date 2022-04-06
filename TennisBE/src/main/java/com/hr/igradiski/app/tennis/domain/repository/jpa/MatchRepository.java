package com.hr.igradiski.app.tennis.domain.repository.jpa;

import com.hr.igradiski.app.tennis.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
}
