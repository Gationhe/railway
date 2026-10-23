package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.EmpProfilePO;

public interface EmpProfileRepository extends JpaRepository<EmpProfilePO, String> {

}
