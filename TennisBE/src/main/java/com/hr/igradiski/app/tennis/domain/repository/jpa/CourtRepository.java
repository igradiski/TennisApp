package com.hr.igradiski.app.tennis.domain.repository.jpa;

import com.hr.igradiski.app.tennis.domain.Court;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourtRepository extends JpaRepository<Court,Long> {

    boolean existsByName(String name);

    Page<Court> findAll(Specification<Court> specification, Pageable pageable);

    void deleteByIdIn(List<Long> ids);
}
