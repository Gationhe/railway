package com.gationhe.railway.internal.interfaces.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gationhe.railway.internal.application.service.ProfileApplicationService;
import com.gationhe.railway.internal.interfaces.assembler.ProfileAssembler;
import com.gationhe.railway.internal.interfaces.dto.CreateProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.ProfileResponse;
import com.gationhe.railway.internal.interfaces.dto.SearchProfileRequest;
import com.gationhe.railway.internal.interfaces.dto.UpdateProfileRequest;
import com.gationhe.railway.shared.dto.Req;
import com.gationhe.railway.shared.dto.Resp;
import com.gationhe.railway.shared.dto.RespInfo;

import jakarta.validation.Valid;
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
    public Resp<ProfileResponse> createProfile(
            @Valid @RequestBody Req<CreateProfileRequest> request,
            @RequestHeader(value = "X-OperatorId", required = true) String operatorId) {
        return new Resp<ProfileResponse>(
                RespInfo.successRespInfo(),
                ProfileAssembler.toProfileResponse(profileApplicationService.createProfile(
                        ProfileAssembler.toCreateProfileCommand(request.getTranrq()), operatorId)));
    }

    /**
     * 更新員工基本資料
     * 
     * @param request 請求資料
     * @param operatorId 操作人員
     * @return
     */
    @PostMapping("/update")
    public Resp<ProfileResponse> updateProfile(
            @Valid @RequestBody Req<UpdateProfileRequest> request,
            @RequestHeader(value = "X-OperatorId", required = true) String operatorId) {
        return new Resp<ProfileResponse>(
                RespInfo.successRespInfo(),
                ProfileAssembler.toProfileResponse(profileApplicationService.updateProfile(
                        ProfileAssembler.toUpdateProfileCommand(request.getTranrq()), operatorId)));
    }

    /**
     * 條件查詢多筆員工基本資料
     * 
     * @param request 請求資料
     * @return 符合條件的員工基本資料列表
     */
    @PostMapping("/search")
    public Resp<List<ProfileResponse>> searchProfiles(
            @Valid @RequestBody Req<SearchProfileRequest> request) {
        return new Resp<List<ProfileResponse>>(
                RespInfo.successRespInfo(),
                ProfileAssembler.toProfileResponses(profileApplicationService.searchProfiles(
                        ProfileAssembler.toSearchProfileCommand(request.getTranrq()))));
    }

    /**
     * 查詢單筆員工基本資料
     * 
     * @param empId 員工代號
     * @return
     */
    @GetMapping("/{empId}")
    public Resp<ProfileResponse> getProfile(@PathVariable("empId") String empId) {
        return new Resp<ProfileResponse>(
                RespInfo.successRespInfo(),
                ProfileAssembler.toProfileResponse(profileApplicationService.getProfile(empId)));
    }
}
