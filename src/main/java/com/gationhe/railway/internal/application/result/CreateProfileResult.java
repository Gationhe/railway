package com.gationhe.railway.internal.application.result;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;

public record CreateProfileResult(
        String empId,
        String name,
        String englishName,
        String idNo,
        LocalDate birthday,
        String phone,
        String tel,
        String emergencyContact,
        String depNo,
        String position,
        LocalDate employmentDate,
        LocalDate terminationDate,
        String status,
        String updatedBy,
        OffsetDateTime updatedAt) {

    public static CreateProfileResult from(EmpProfileAggregate profile) {
        if (profile == null) {
            return null;
        }
        return new CreateProfileResult(
                profile.getEmpId(),
                profile.getName(),
                profile.getEnglishName(),
                profile.getIdNo(),
                profile.getBirthday(),
                profile.getPhone(),
                profile.getTel(),
                profile.getEmergencyContact(),
                profile.getDepNo(),
                profile.getPosition(),
                profile.getEmploymentDate(),
                profile.getTerminationDate(),
                profile.getStatus(),
                profile.getUpdatedBy(),
                profile.getUpdatedAt());
    }
}
