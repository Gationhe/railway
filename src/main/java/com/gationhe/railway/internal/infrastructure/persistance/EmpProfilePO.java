package com.gationhe.railway.internal.infrastructure.persistance;

import java.io.Serializable;
import java.sql.Date;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emp_profile", schema = "internal")
public class EmpProfilePO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 員工代號 */
    @Id 
    @Column(name = "emp_id", nullable = false)
    private String empId;

    /** 姓名 */
    @Column(name = "name", nullable = false)
    private String name;

    /** 英文姓名 */
    @Column(name = "english_name")
    private String englishName;

    /** 身分證號 */
    @Column(name = "id_no", nullable = false)
    private String idNo;

    /** 出生日期 */
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    /** 連絡電話 */
    @Column(name = "phone", nullable = false)
    private String phone;

    /** 辦公電話 */
    @Column(name = "tel")
    private String tel;

    /** 緊急聯絡人 */
    @Column(name = "emergency_contact")
    private String emergencyContact;

    /** 所屬單位代號 */
    @Column(name = "dep_no", nullable = false)
    private String depNo;

    /** 職稱 */
    @Column(name = "position", nullable = false)
    private String position;

    /** 到職日期 */
    @Column(name = "employment_date", nullable = false)
    private Date employmentDate;

    /** 離職日期 */
    @Column(name = "termination_date")
    private Date terminationDate;

    /** 任職狀況 */
    @Column(name = "status", nullable = false)
    private String status;

    /** 更新人員 (員工代號) */
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    /** 更新時間 */
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

}
