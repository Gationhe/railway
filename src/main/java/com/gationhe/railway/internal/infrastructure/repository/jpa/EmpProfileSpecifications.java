package com.gationhe.railway.internal.infrastructure.repository.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.gationhe.railway.internal.domain.vo.EmpProfileSearchCriteria;
import com.gationhe.railway.internal.infrastructure.persistance.EmpProfilePO;

import jakarta.persistence.criteria.Predicate;

public final class EmpProfileSpecifications {

    private EmpProfileSpecifications() {
    }

    public static Specification<EmpProfilePO> from(EmpProfileSearchCriteria criteria) {
        EmpProfileSearchCriteria searchCriteria = criteria == null
                ? EmpProfileSearchCriteria.empty()
                : criteria;

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(searchCriteria.empId())) {
                predicates.add(criteriaBuilder.equal(root.get("empId"), searchCriteria.empId()));
            }
            if (StringUtils.isNotBlank(searchCriteria.name())) {
                predicates.add(criteriaBuilder.equal(root.get("name"), searchCriteria.name()));
            }
            if (StringUtils.isNotBlank(searchCriteria.englishName())) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.<String>get("englishName")),
                        searchCriteria.englishName().toLowerCase(Locale.ROOT)));
            }
            if (StringUtils.isNotBlank(searchCriteria.idNo())) {
                predicates.add(criteriaBuilder.equal(root.get("idNo"), searchCriteria.idNo()));
            }
            if (!searchCriteria.depNoList().isEmpty()) {
                predicates.add(root.get("depNo").in(searchCriteria.depNoList()));
            }
            if (!searchCriteria.positionList().isEmpty()) {
                predicates.add(root.get("position").in(searchCriteria.positionList()));
            }
            if (!searchCriteria.statusList().isEmpty()) {
                predicates.add(root.get("status").in(searchCriteria.statusList()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
