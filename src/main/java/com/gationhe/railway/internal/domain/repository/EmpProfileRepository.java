package com.gationhe.railway.internal.domain.repository;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;

public interface EmpProfileRepository {

    EmpProfileAggregate save(EmpProfileAggregate aggregate);

    void lockEmpIdGeneration(String year);

    String getLatestEmpId(String year);

}
