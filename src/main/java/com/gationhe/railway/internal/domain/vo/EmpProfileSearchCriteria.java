package com.gationhe.railway.internal.domain.vo;

import java.util.List;

public record EmpProfileSearchCriteria(
        String empId,
        String name,
        String englishName,
        String idNo,
        List<String> depNoList,
        List<String> positionList,
        List<String> statusList) {

    public EmpProfileSearchCriteria {
        depNoList = depNoList == null ? List.of() : List.copyOf(depNoList);
        positionList = positionList == null ? List.of() : List.copyOf(positionList);
        statusList = statusList == null ? List.of() : List.copyOf(statusList);
    }

    public static EmpProfileSearchCriteria empty() {
        return new EmpProfileSearchCriteria(null, null, null, null, List.of(), List.of(), List.of());
    }
}
