package com.gationhe.railway.internal.infrastructure.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.domain.repository.EmpProfileRepository;
import com.gationhe.railway.internal.infrastructure.mapper.EmpProfileMapper;
import com.gationhe.railway.internal.infrastructure.repository.jpa.EmpProfileJpaRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpProfileRepositoryImpl implements EmpProfileRepository {

    private final EmpProfileJpaRepository empProfileJpaRepository;

    private final EntityManager entityManager;

    @Override
    public EmpProfileAggregate save(EmpProfileAggregate aggregate) {
        return EmpProfileMapper.toAggregate(
                empProfileJpaRepository.save(EmpProfileMapper.toPO(aggregate)));
    }

    @Override
    public void lockEmpIdGeneration(String year) {
        entityManager.createNativeQuery(
                "SELECT 1 FROM (SELECT pg_advisory_xact_lock(hashtext('emp_profile_emp_id'), :year)) l")
                .setParameter("year", Integer.parseInt(year))
                .getSingleResult();
    }

    @Override
    public String getLatestEmpId(String year) {
        return empProfileJpaRepository
                .findLatestEmpIdByYear(year, PageRequest.of(0, 1))
                .stream()
                .findFirst()
                .orElse(null);
    }

}
