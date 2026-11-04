package com.gationhe.railway.internal.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.domain.repository.EmpProfileRepository;
import com.gationhe.railway.internal.domain.vo.EmpProfileSearchCriteria;
import com.gationhe.railway.internal.infrastructure.mapper.EmpProfileMapper;
import com.gationhe.railway.internal.infrastructure.repository.jpa.EmpProfileJpaRepository;
import com.gationhe.railway.internal.infrastructure.repository.jpa.EmpProfileLogRepository;
import com.gationhe.railway.internal.infrastructure.repository.jpa.EmpProfileSpecifications;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpProfileRepositoryImpl implements EmpProfileRepository {

    private final EmpProfileJpaRepository empProfileJpaRepository;

    private final EmpProfileLogRepository empProfileLogRepository;

    private final EntityManager entityManager;

    @Override
    public EmpProfileAggregate save(EmpProfileAggregate aggregate) {
        return EmpProfileMapper.toAggregate(
                empProfileJpaRepository.save(EmpProfileMapper.toPO(aggregate)));
    }

    @Override
    public Optional<EmpProfileAggregate> findByEmpId(String empId) {
        return empProfileJpaRepository.findById(empId).map(EmpProfileMapper::toAggregate);
    }

    @Override
    public List<EmpProfileAggregate> search(EmpProfileSearchCriteria criteria) {
        return empProfileJpaRepository
                .findAll(EmpProfileSpecifications.from(criteria), Sort.by(Sort.Direction.ASC, "empId"))
                .stream()
                .map(EmpProfileMapper::toAggregate)
                .toList();
    }

    @Override
    public void saveLog(EmpProfileAggregate aggregate, String mod) {
        empProfileLogRepository.save(EmpProfileMapper.toLogPO(aggregate, mod));
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
