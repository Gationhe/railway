package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
@IdClass(EmpSalaryLogPKPO.class)
@Table(name = "emp_salary_log")
public class EmpSalaryLogPO implements Serializable {

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

    /** 預計實發薪資 */
    @Column(name = "expected_net_salary", nullable = false)
    private BigDecimal expectedNetSalary;

    /** 實際實發薪資 */
    @Column(name = "actual_net_salary", nullable = false)
    private BigDecimal actualNetSalary;

    /** 發放時間 */
    @Column(name = "transaction_time", nullable = false)
    private OffsetDateTime transactionTime;

}