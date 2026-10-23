package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpSalaryPO;

public interface EmpSalaryRepository extends JpaRepository<EmpSalaryPO, String> {

}
