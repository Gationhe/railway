package com.gationhe.railway.internal.interfaces.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateProfileRequest {

    /** 姓名 */
    @NotBlank(message = "name 不能為空")
    @Size(max = 50, message = "name 長度不得超過 50")
    private String name;

    /** 英文姓名 */
    @Size(max = 50, message = "englishName 長度不得超過 50")
    private String englishName;

    /** 身分證號 */
    @NotBlank(message = "idNo 不能為空")
    @Size(max = 10, message = "idNo 長度不得超過 10")
    private String idNo;

    /** 出生日期 */
    @NotNull(message = "birthday 不能為空")
    private LocalDate birthday;

    /** 連絡電話 */
    @NotBlank(message = "phone 不能為空")
    @Size(max = 15, message = "phone 長度不得超過 15")
    @Pattern(regexp = "^\\+?[0-9]{1,15}$", message = "phone 格式不正確")
    private String phone;

    /** 辦公電話 */
    @Size(max = 15, message = "tel 長度不得超過 15")
    @Pattern(regexp = "^[0-9]{10}(#[0-9]+)?$", message = "tel 格式不正確")
    private String tel;

    /** 緊急聯絡人 */
    @Size(max = 50, message = "emergencyContact 長度不得超過 50")
    private String emergencyContact;

    /** 所屬單位代號 */
    @NotBlank(message = "depNo 不能為空")
    @Size(max = 10, message = "depNo 長度不得超過 10")
    private String depNo;

    /** 職稱 */
    @NotBlank(message = "position 不能為空")
    @Size(max = 10, message = "position 長度不得超過 10")
    private String position;

    /** 到職日期 */
    @NotNull(message = "employmentDate 不能為空")
    private LocalDate employmentDate;

}