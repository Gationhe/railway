package com.gationhe.railway.internal.infrastructure.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gationhe.railway.internal.infrastructure.persistance.EmpProfilePO;

public interface EmpProfileJpaRepository extends JpaRepository<EmpProfilePO, String> {

    @Query("SELECT e.empId FROM EmpProfilePO e WHERE e.empId LIKE CONCAT('E', :year, '%') ORDER BY e.empId DESC")
    List<String> findLatestEmpIdByYear(@Param("year") String year, Pageable pageable);

}
