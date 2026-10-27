package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpSalaryHistoryPKPO;
import com.gationhe.railway.internal.infrastructure.persistance.EmpSalaryHistoryPO;

public interface EmpSalaryHistoryRepository extends JpaRepository<EmpSalaryHistoryPO, EmpSalaryHistoryPKPO> {

}
