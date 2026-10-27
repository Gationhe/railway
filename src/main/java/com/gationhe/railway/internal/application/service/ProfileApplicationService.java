package com.gationhe.railway.internal.application.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gationhe.railway.internal.application.command.CreateProfileCommand;
import com.gationhe.railway.internal.application.result.CreateProfileResult;
import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.domain.factory.EmpProfileFactory;
import com.gationhe.railway.internal.domain.repository.EmpProfileRepository;

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
    public CreateProfileResult createProfile(CreateProfileCommand command, String operatorId) {
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

        return CreateProfileResult.from(empProfileRepository.save(profile));
    }
}
