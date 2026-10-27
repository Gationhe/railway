package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpLeavePKPO;
import com.gationhe.railway.internal.infrastructure.persistance.EmpLeavePO;

public interface EmpLeaveRepository extends JpaRepository<EmpLeavePO, EmpLeavePKPO> {

}
