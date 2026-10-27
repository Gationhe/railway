package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emp_salary_log", schema = "internal")
public class EmpSalaryLogPO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 主鍵 */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** 員工代號 */
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 年月 */
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

    /** 更新人員 (員工代號) */
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    /** 更新時間 */
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

}