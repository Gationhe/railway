package com.gationhe.railway.internal.interfaces.assembler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gationhe.railway.internal.application.command.CreateProfileCommand;
import com.gationhe.railway.internal.application.command.SearchProfileCommand;
import com.gationhe.railway.internal.application.command.UpdateProfileCommand;
import com.gationhe.railway.internal.application.result.ProfileResult;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.ProfileResponse;
import com.gationhe.railway.internal.interfaces.dto.SearchProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.UpdateProfileRequest;

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

    public static UpdateProfileCommand toUpdateProfileCommand(UpdateProfileRequest request) {
        if (request == null) {
            return null;
        }
        return new UpdateProfileCommand(
                request.getEmpId(),
                request.getName(),
                request.getEnglishName(),
                request.getIdNo(),
                request.getBirthday(),
                request.getPhone(),
                request.getTel(),
                request.getEmergencyContact(),
                request.getDepNo(),
                request.getPosition(),
                request.getEmploymentDate(),
                request.getTerminationDate(),
                request.getStatus());
    }

    public static ProfileResponse toProfileResponse(ProfileResult profile) {
        if (profile == null) {
            return null;
        }
        return new ProfileResponse(
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

    public static SearchProfileCommand toSearchProfileCommand(SearchProfileRequest request) {
        if (request == null) {
            return SearchProfileCommand.empty();
        }
        return new SearchProfileCommand(
                StringUtils.trimToNull(request.getEmpId()),
                StringUtils.trimToNull(request.getName()),
                StringUtils.trimToNull(request.getEnglishName()),
                StringUtils.trimToNull(request.getIdNo()),
                normalizeList(request.getDepNoList()),
                normalizeList(request.getPositionList()),
                normalizeList(request.getStatusList()));
    }

    public static List<ProfileResponse> toProfileResponses(List<ProfileResult> profiles) {
        if (profiles == null) {
            return List.of();
        }
        return profiles.stream()
                .map(ProfileAssembler::toProfileResponse)
                .toList();
    }

    private static List<String> normalizeList(List<String> values) {
        if (values == null) {
            return List.of();
        }
        return values.stream()
                .map(StringUtils::trimToNull)
                .filter(StringUtils::isNotBlank)
                .toList();
    }
}
