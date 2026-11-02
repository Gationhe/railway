package com.gationhe.railway.internal.application.command;

import java.time.LocalDate;

public record UpdateProfileCommand(
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
        String status) {
}
