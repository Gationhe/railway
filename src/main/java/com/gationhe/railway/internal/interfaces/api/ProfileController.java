package com.gationhe.railway.internal.interfaces.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gationhe.railway.internal.application.service.ProfileApplicationService;
import com.gationhe.railway.internal.interfaces.assembler.ProfileAssembler;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileResponse;
import com.gationhe.railway.shared.dto.Req;
import com.gationhe.railway.shared.dto.Resp;
import com.gationhe.railway.shared.dto.RespInfo;
import com.gationhe.railway.shared.enums.ReturnCodeAndDescEnum;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/profile")
public class ProfileController {

    /** ProfileApplicationService */
    private final ProfileApplicationService profileApplicationService;

    /**
     * 新增員工基本資料
     * 
     * @param request 請求資料
     * @param operatorId 操作人員
     * @return
     */
    @PostMapping("/create")
    public Resp<CreateProfileResponse> createProfile(
            @RequestBody Req<CreateProfileRequest> request,
            @RequestHeader(value = "X-OperatorId", required = true) String operatorId) {
        return new Resp<CreateProfileResponse>(
                new RespInfo(true, ReturnCodeAndDescEnum.SUCCESS.getCode(), ReturnCodeAndDescEnum.SUCCESS.getDesc(),
                        null),
                ProfileAssembler.toCreateProfileResponse(profileApplicationService.createProfile(
                ProfileAssembler.toCreateProfileCommand(request.getTranrq()), operatorId)));
    }
}
