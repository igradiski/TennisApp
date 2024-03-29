package com.hr.igradiski.app.tennis.domain.specification;

import com.hr.igradiski.app.tennis.domain.Court;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CourtSpecification {

    public static Specification<Court> getCourtSpecification(FilterDto filterDto){

        return ((root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if(!filterDto.getName().isBlank())
                predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+filterDto.getName().toLowerCase()+"%"));

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
    }

}
