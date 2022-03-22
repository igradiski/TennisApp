/*package hr.deepit.dzsprofiling.core.domain.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public class UserSpecification {

    private UserSpecification() {
        throw new IllegalStateException("Class with static methods ...");
    }

    public static Specification<User> findAll(UserFilterDto filterBy, Pageable pageable) {
        return new Specification<User>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Path<Long> idPath = root.get(User_.id);
                Path<String> usernamePath = root.get(User_.username);
                Path<String> firstNamePath = root.get(User_.firstName);
                Path<String> lastNamePath = root.get(User_.lastName);
                Path<String> emailPath = root.get(User_.email);
                Path<ActivityType> activityPath = root.get(User_.activity);

                List<Order> orderByList = new ArrayList<>();
                if (pageable.getSort().isSorted()) {

                    pageable.getSort().stream().forEach(order -> {

                        if ((User_.USERNAME).equals(order.getProperty())) {
                            SpecificationUtil.addOrder(order, orderByList, criteriaBuilder, usernamePath);
                        }

                        if ((User_.FIRST_NAME).equals(order.getProperty())) {
                            SpecificationUtil.addOrder(order, orderByList, criteriaBuilder, firstNamePath);
                        }

                        if ((User_.LAST_NAME).equals(order.getProperty())) {
                            SpecificationUtil.addOrder(order, orderByList, criteriaBuilder, lastNamePath);
                        }

                        if ((User_.EMAIL).equals(order.getProperty())) {
                            SpecificationUtil.addOrder(order, orderByList, criteriaBuilder, emailPath);
                        }

                        if ((User_.ACTIVITY).equals(order.getProperty())) {
                            SpecificationUtil.addOrder(order, orderByList, criteriaBuilder, activityPath);
                        }
                    });

                }

                if (orderByList.isEmpty()) {
                    orderByList.add(criteriaBuilder.asc(idPath));
                }

                query.orderBy(orderByList);

                Predicate loginPredicate = null;
                Predicate userFirstNamePredicate = null;
                Predicate userLastNamePredicate = null;
                Predicate userEmailPredicate = null;
                Predicate userActivityPredicate = null;
                Predicate queryPredicate = null;

                if (filterBy != null) {

                    if (StringUtils.isNoneBlank(filterBy.getUsername())) {
                        loginPredicate = criteriaBuilder
                                .and(criteriaBuilder.like(criteriaBuilder.upper(usernamePath),
                                        "%" + filterBy.getUsername().toUpperCase() + "%"));
                    }

                    if (StringUtils.isNoneBlank(filterBy.getFirstName())) {
                        userFirstNamePredicate = criteriaBuilder
                                .and(criteriaBuilder.like(criteriaBuilder.upper(firstNamePath),
                                        "%" + filterBy.getFirstName().toUpperCase() + "%"));
                    }

                    if (StringUtils.isNoneBlank(filterBy.getLastName())) {
                        userLastNamePredicate = criteriaBuilder.and(criteriaBuilder.like(
                                criteriaBuilder.upper(lastNamePath), "%" + filterBy.getLastName().toUpperCase() + "%"));
                    }

                    if (StringUtils.isNoneBlank(filterBy.getEmail())) {
                        userEmailPredicate = criteriaBuilder
                                .and(criteriaBuilder.like(criteriaBuilder.upper(emailPath),
                                        "%" + filterBy.getEmail().toUpperCase() + "%"));
                    }

                    if (filterBy.getActivity() != null) {
                        userActivityPredicate = criteriaBuilder.equal(activityPath, filterBy.getActivity());
                    }


                    if (StringUtils.isNoneBlank(filterBy.getQuery())) {

                        queryPredicate = criteriaBuilder.and(criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.upper(usernamePath.as(String.class)),
                                        "%" + filterBy.getQuery().toUpperCase() + "%"),
                                criteriaBuilder.like(criteriaBuilder.upper(firstNamePath.as(String.class)),
                                        "%" + filterBy.getQuery().toUpperCase() + "%"),
                                criteriaBuilder.like(criteriaBuilder.upper(lastNamePath.as(String.class)),
                                        "%" + filterBy.getQuery().toUpperCase() + "%"),
                                criteriaBuilder.like(criteriaBuilder.upper(emailPath.as(String.class)),
                                        "%" + filterBy.getQuery().toUpperCase() + "%"),
                                criteriaBuilder.like(criteriaBuilder.upper(activityPath.as(String.class)),
                                        "%" + filterBy.getQuery().toUpperCase() + "%")
                        ));
                    }
                }

                return criteriaBuilder.and(
                        loginPredicate != null ? loginPredicate : criteriaBuilder.conjunction(),
                        userFirstNamePredicate != null ? userFirstNamePredicate : criteriaBuilder.conjunction(),
                        userLastNamePredicate != null ? userLastNamePredicate : criteriaBuilder.conjunction(),
                        userEmailPredicate != null ? userEmailPredicate : criteriaBuilder.conjunction(),
                        userActivityPredicate != null ? userActivityPredicate : criteriaBuilder.conjunction(),
                        queryPredicate != null ? queryPredicate : criteriaBuilder.conjunction());
            }
        };
    }
}

 */