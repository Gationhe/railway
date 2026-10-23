package com.gationhe.railway.internal.infrastructure.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpSalaryLogPKPO {

    /** 員工代號 */
    private String empId;

    /** 年月 */
    private String dataMonth;

}
