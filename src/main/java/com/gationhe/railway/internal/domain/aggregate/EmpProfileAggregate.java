package com.gationhe.railway.internal.domain.aggregate;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class EmpProfileAggregate {

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

    /** 任職狀況 */
    private String status;

    /** 更新人員 (員工代號) */
    private String updatedBy;

    /** 更新時間 */
    private OffsetDateTime updatedAt;

    private EmpProfileAggregate(
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
            String status,
            String updatedBy,
            OffsetDateTime updatedAt) {
        this.empId = empId;
        this.name = name;
        this.englishName = englishName;
        this.idNo = idNo;
        this.birthday = birthday;
        this.phone = phone;
        this.tel = tel;
        this.emergencyContact = emergencyContact;
        this.depNo = depNo;
        this.position = position;
        this.employmentDate = employmentDate;
        this.terminationDate = terminationDate;
        this.status = status;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    public static EmpProfileAggregate create(
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
            String operatorId,
            OffsetDateTime now) {
        return new EmpProfileAggregate(
                empId,
                name,
                englishName,
                idNo,
                birthday,
                phone,
                tel,
                emergencyContact,
                depNo,
                position,
                employmentDate,
                null,
                "1",
                operatorId,
                now);
    }

    public static EmpProfileAggregate restore(
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
            String status,
            String updatedBy,
            OffsetDateTime updatedAt) {
        return new EmpProfileAggregate(
                empId,
                name,
                englishName,
                idNo,
                birthday,
                phone,
                tel,
                emergencyContact,
                depNo,
                position,
                employmentDate,
                terminationDate,
                status,
                updatedBy,
                updatedAt);
    }
}
