package com.gationhe.railway.internal.infrastructure.persistance;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class EmpAttendancePKPO {

    /** 員工代號 */
    private String empId;

    /** 出勤日期 */
    private Date attendDate;

}
