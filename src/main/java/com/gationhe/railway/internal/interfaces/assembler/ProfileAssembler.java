package com.gationhe.railway.internal.interfaces.assembler;

import com.gationhe.railway.internal.application.command.CreateProfileCommand;
import com.gationhe.railway.internal.application.result.CreateProfileResult;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileResponse;

public class ProfileAssembler {

    public static CreateProfileCommand toCreateProfileCommand(CreateProfileRequest request) {
        if (request == null) {
            return null;
        }
        return new CreateProfileCommand(
                request.getName(),
                request.getEnglishName(),
                request.getIdNo(),
                request.getBirthday(),
                request.getPhone(),
                request.getTel(),
                request.getEmergencyContact(),
                request.getDepNo(),
                request.getPosition(),
                request.getEmploymentDate());
    }

    public static CreateProfileResponse toCreateProfileResponse(CreateProfileResult profile) {
        if (profile == null) {
            return null;
        }
        return new CreateProfileResponse(
                profile.empId(),
                profile.name(),
                profile.englishName(),
                profile.idNo(),
                profile.birthday(),
                profile.phone(),
                profile.tel(),
                profile.emergencyContact(),
                profile.depNo(),
                profile.position(),
                profile.employmentDate(),
                profile.terminationDate(),
                profile.status(),
                profile.updatedBy(),
                profile.updatedAt());
    }
}
