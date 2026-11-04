package com.gationhe.railway.internal.application.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gationhe.railway.internal.application.command.CreateProfileCommand;
import com.gationhe.railway.internal.application.command.SearchProfileCommand;
import com.gationhe.railway.internal.application.command.UpdateProfileCommand;
import com.gationhe.railway.internal.application.result.ProfileResult;
import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.domain.factory.EmpProfileFactory;
import com.gationhe.railway.internal.domain.repository.EmpProfileRepository;
import com.gationhe.railway.internal.domain.vo.EmpProfileSearchCriteria;
import com.gationhe.railway.shared.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileApplicationService {

    private final EmpProfileRepository empProfileRepository;

    private final EmpProfileFactory empProfileFactory;

    /**
     * 建立員工基本資料
     * 
     * @param command    建立員工基本資料命令
     * @param operatorId 操作人員員工編號
     * @return 建立員工基本資料結果
     */
    @Transactional(rollbackFor = Exception.class)
    public ProfileResult createProfile(CreateProfileCommand command, String operatorId) {
        EmpProfileAggregate profile = EmpProfileAggregate.create(
                empProfileFactory.getAvailableEmpId(),
                command.name(),
                command.englishName(),
                command.idNo(),
                command.birthday(),
                command.phone(),
                command.tel(),
                command.emergencyContact(),
                command.depNo(),
                command.position(),
                command.employmentDate(),
                operatorId,
                OffsetDateTime.now());

        return ProfileResult.from(empProfileRepository.save(profile));
    }

    /**
     * 更新員工基本資料
     * 
     * @param command    更新員工基本資料命令
     * @param operatorId 操作人員員工編號
     * @return 更新員工基本資料結果
     */
    @Transactional(rollbackFor = Exception.class)
    public ProfileResult updateProfile(UpdateProfileCommand command, String operatorId) {
        EmpProfileAggregate profile = empProfileRepository.findByEmpId(command.empId())
                .orElseThrow(() -> new DataNotFoundException("查無員工基本資料，員工代號為：" + command.empId()));

        empProfileRepository.saveLog(profile, "U");

        profile.update(
                command.name(),
                command.englishName(),
                command.idNo(),
                command.birthday(),
                command.phone(),
                command.tel(),
                command.emergencyContact(),
                command.depNo(),
                command.position(),
                command.employmentDate(),
                command.terminationDate(),
                command.status(),
                operatorId,
                OffsetDateTime.now());

        return ProfileResult.from(empProfileRepository.save(profile));
    }

    /**
     * 查詢單筆員工基本資料
     * 
     * @param empId 員工代號
     * @return 查詢員工基本資料結果
     */
    @Transactional(readOnly = true)
    public ProfileResult getProfile(String empId) {
        return empProfileRepository.findByEmpId(empId)
                .map(ProfileResult::from)
                .orElseThrow(() -> new DataNotFoundException("查無員工基本資料，員工代號為：" + empId));
    }

    /**
     * 條件查詢多筆員工基本資料
     * 
     * @param command 查詢條件
     * @return 符合條件的員工基本資料列表
     */
    @Transactional(readOnly = true)
    public List<ProfileResult> searchProfiles(SearchProfileCommand command) {
        SearchProfileCommand searchCommand = command == null ? SearchProfileCommand.empty() : command;

        return empProfileRepository.search(new EmpProfileSearchCriteria(
                searchCommand.empId(),
                searchCommand.name(),
                searchCommand.englishName(),
                searchCommand.idNo(),
                searchCommand.depNoList(),
                searchCommand.positionList(),
                searchCommand.statusList())).stream()
                .map(ProfileResult::from)
                .toList();
    }
}
