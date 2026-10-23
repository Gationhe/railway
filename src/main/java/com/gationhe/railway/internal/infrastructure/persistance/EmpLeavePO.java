package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.sql.Date;
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
@IdClass(EmpLeavePKPO.class)
@Table(name = "emp_leave")
public class EmpLeavePO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 員工代號 */
    @Id
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 請假日期 */
    @Id
    @Column(name = "leave_date", nullable = false)
    private Date leaveDate;

    /** 是否為全天 */
    @Column(name = "is_all_day", nullable = false)
    private boolean isAllDay;

    /** 批准階段 */
    @Column(name = "approved_status", nullable = false)
    private String approvedStatus;

    /** 預計請假時段（起） */
    @Column(name = "expected_leave_start_time")
    private OffsetDateTime expectedLeaveStartTime;

    /** 預計請假時段（迄） */
    @Column(name = "expected_leave_end_time")
    private OffsetDateTime expectedLeaveEndTime;

    /** 假別 */
    @Column(name = "leave_type", nullable = false)
    private String leaveType;

    /** 職務代理人（一）員工代號 */
    @Column(name = "substitute_1", nullable = false)
    private String substitute1;

    /** 職務代理人（二）員工代號 */
    @Column(name = "substitute_2")
    private String substitute2;

}