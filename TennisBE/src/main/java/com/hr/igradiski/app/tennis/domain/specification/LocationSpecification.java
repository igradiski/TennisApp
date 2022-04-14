package com.hr.igradiski.app.tennis.domain.specification;

import com.hr.igradiski.app.tennis.domain.Location;
import com.hr.igradiski.app.tennis.domain.dto.FilterDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class LocationSpecification {

    public static Specification<Location> getLocationSpecification(FilterDto filterDto){

        return ((root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if(!filterDto.getName().isEmpty())
                predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+filterDto.getName().toLowerCase()+"%"));

            if(!filterDto.getDateFrom().isEmpty() && !filterDto.getDateUntil().isEmpty())
                predicateList.add(criteriaBuilder.between(root.get("updated_date"), Instant.parse(filterDto.getDateFrom()),Instant.parse(filterDto.getDateUntil())));

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
    }
}
