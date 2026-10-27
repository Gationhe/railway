package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emp_salary", schema = "internal")
public class EmpSalaryPO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 員工代號 */
    @Id
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 底薪 */
    @Column(name = "base_salary", nullable = false)
    private BigDecimal baseSalary;

    /** 津貼 */
    @Column(name = "allowance", nullable = false)
    private BigDecimal allowance;

    /** 勞健保扣款 */
    @Column(name = "insurance_deduction", nullable = false)
    private BigDecimal insuranceDeduction;

    /** 實發薪資 */
    @Column(name = "net_salary", nullable = false)
    private BigDecimal netSalary;

    /** 生效日期 */
    @Column(name = "effective_date", nullable = false)
    private Date effectiveDate;

}