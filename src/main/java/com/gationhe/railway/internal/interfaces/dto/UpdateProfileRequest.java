package com.gationhe.railway.internal.interfaces.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Getter;

@Getter
public class UpdateProfileRequest extends CreateProfileRequest {

    /** 員工代號 */
    @NotBlank(message = "empId 不能為空")
    @Size(max = 10, message = "empId 長度不得超過 10")
    @Pattern(regexp = "^E[0-9]{7}$", message = "empId 格式不正確")
    private String empId;

    /** 離職日期 */
    private LocalDate terminationDate;

    /** 狀態 */
    @NotBlank(message = "status 不能為空")
    @Size(max = 1, message = "status 長度不得超過 1")
    @Pattern(regexp = "^[0123]$", message = "status 格式不正確")
    private String status;

}
