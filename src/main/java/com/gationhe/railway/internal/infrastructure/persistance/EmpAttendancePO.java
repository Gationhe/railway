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
@IdClass(EmpAttendancePKPO.class)
@Table(name = "emp_attendance", schema = "internal")
public class EmpAttendancePO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 員工代號 */
    @Id
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 出勤日期 */
    @Id
    @Column(name = "attend_date", nullable = false)
    private Date attendDate;

    /** 預計上班時間 */
    @Column(name = "expected_start_time", nullable = false)
    private OffsetDateTime expectedStartTime;

    /** 預計下班時間 */
    @Column(name = "expected_end_time", nullable = false)
    private OffsetDateTime expectedEndTime;

    /** 實際上班時間 */
    @Column(name = "actual_start_time")
    private OffsetDateTime actualStartTime;

    /** 實際下班時間 */
    @Column(name = "actual_end_time")
    private OffsetDateTime actualEndTime;

    /** 是否休假 */
    @Column(name = "has_leave", nullable = false)
    private boolean hasLeave;

    /** 是否異常 */
    @Column(name = "is_abnormal")
    private Boolean isAbnormal;

}