package com.gationhe.railway.internal.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gationhe.railway.internal.infrastructure.persistance.DepOverviewPO;

public interface DepOverviewRepository extends JpaRepository<DepOverviewPO, String> {

}
