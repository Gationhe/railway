package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpAttendancePKPO;
import com.gationhe.railway.internal.infrastructure.persistance.EmpAttendancePO;

public interface EmpAttendanceRepository extends JpaRepository<EmpAttendancePO, EmpAttendancePKPO> {

}
