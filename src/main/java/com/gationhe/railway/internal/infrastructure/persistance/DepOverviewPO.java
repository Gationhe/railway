package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dep_overview")
public class DepOverviewPO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 單位名稱 */
    @Column(name = "dep_name", nullable = false)
    private String depName;

    /** 單位代號 */
    @Id 
    @Column(name = "dep_no", nullable = false)
    private String depNo;

    /** 單位負責人員工代號 */
    @Column(name = "dep_leader_emp_id", nullable = false)
    private String depLeaderEmpId;

    /** 單位階層 */
    @Column(name = "dep_layer", nullable = false)
    private String depLayer;

    /** 上層單位 */
    @Column(name = "upper_dep")
    private String upperDep;

}