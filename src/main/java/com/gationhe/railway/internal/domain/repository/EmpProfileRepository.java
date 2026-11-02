package com.gationhe.railway.internal.domain.repository;

import java.util.Optional;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;

public interface EmpProfileRepository {

    EmpProfileAggregate save(EmpProfileAggregate aggregate);

    Optional<EmpProfileAggregate> findByEmpId(String empId);

    void saveLog(EmpProfileAggregate aggregate, String mod);

    void lockEmpIdGeneration(String year);

    String getLatestEmpId(String year);

}
