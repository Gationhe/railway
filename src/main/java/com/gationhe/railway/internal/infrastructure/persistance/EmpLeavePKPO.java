package com.gationhe.railway.internal.infrastructure.persistance;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class EmpLeavePKPO {

    /** 員工代號 */
    private String empId;

    /** 請假日期 */
    private Date leaveDate;

}
