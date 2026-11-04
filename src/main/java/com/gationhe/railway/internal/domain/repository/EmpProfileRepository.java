package com.gationhe.railway.internal.domain.repository;

import java.util.List;
import java.util.Optional;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.domain.vo.EmpProfileSearchCriteria;

public interface EmpProfileRepository {

    EmpProfileAggregate save(EmpProfileAggregate aggregate);

    Optional<EmpProfileAggregate> findByEmpId(String empId);

    List<EmpProfileAggregate> search(EmpProfileSearchCriteria criteria);

    void saveLog(EmpProfileAggregate aggregate, String mod);

    void lockEmpIdGeneration(String year);

    String getLatestEmpId(String year);

}
