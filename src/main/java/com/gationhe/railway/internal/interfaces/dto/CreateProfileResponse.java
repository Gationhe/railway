package com.gationhe.railway.internal.interfaces.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProfileResponse {

    /** 員工代號 */
    private String empId;

    /** 姓名 */
    private String name;

    /** 英文姓名 */
    private String englishName;

    /** 身分證號 */
    private String idNo;

    /** 出生日期 */
    private LocalDate birthday;

    /** 連絡電話 */
    private String phone;

    /** 辦公電話 */
    private String tel;

    /** 緊急聯絡人 */
    private String emergencyContact;

    /** 所屬單位代號 */
    private String depNo;

    /** 職稱 */
    private String position;

    /** 到職日期 */
    private LocalDate employmentDate;

    /** 離職日期 */
    private LocalDate terminationDate;

    /** 狀態 */
    private String status;

    /** 更新人員 */
    private String updatedBy;

    /** 更新時間 */
    private OffsetDateTime updatedAt;

}