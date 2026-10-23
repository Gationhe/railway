package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(EmpSalaryHistoryPKPO.class)
@Table(name = "emp_salary_history")
public class EmpSalaryHistoryPO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 員工代號 */
    @Id 
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 年月 */
    @Id 
    @Column(name = "data_month", nullable = false)
    private String dataMonth;

    /** 當月底薪 */
    @Column(name = "past_salary", nullable = false)
    private BigDecimal pastSalary;

    /** 當月津貼 */
    @Column(name = "past_allowance", nullable = false)
    private BigDecimal pastAllowance;

    /** 勞健保扣款 */
    @Column(name = "past_insurance_deduction", nullable = false)
    private BigDecimal pastInsuranceDeduction;

    /** 實發薪資 */
    @Column(name = "past_net_salary", nullable = false)
    private BigDecimal pastNetSalary;

}