package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpSalaryLogPKPO;
import com.gationhe.railway.internal.infrastructure.persistance.EmpSalaryLogPO;

public interface EmpSalaryLogRepository extends JpaRepository<EmpSalaryLogPO, EmpSalaryLogPKPO> {

}
