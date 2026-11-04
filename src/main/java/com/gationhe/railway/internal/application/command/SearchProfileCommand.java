package com.gationhe.railway.internal.application.command;

import java.util.List;

public record SearchProfileCommand(
        String empId,
        String name,
        String englishName,
        String idNo,
        List<String> depNoList,
        List<String> positionList,
        List<String> statusList) {

    public SearchProfileCommand {
        depNoList = depNoList == null ? List.of() : List.copyOf(depNoList);
        positionList = positionList == null ? List.of() : List.copyOf(positionList);
        statusList = statusList == null ? List.of() : List.copyOf(statusList);
    }

    public static SearchProfileCommand empty() {
        return new SearchProfileCommand(null, null, null, null, List.of(), List.of(), List.of());
    }
}
