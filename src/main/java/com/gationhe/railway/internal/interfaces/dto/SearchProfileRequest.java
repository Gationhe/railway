package com.gationhe.railway.internal.interfaces.dto;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SearchProfileRequest {

    /** 員工代號 */
    @Size(max = 10, message = "empId 長度不得超過 10")
    private String empId;

    /** 姓名 */
    @Size(max = 50, message = "name 長度不得超過 50")
    private String name;

    /** 英文姓名 */
    @Size(max = 50, message = "englishName 長度不得超過 50")
    private String englishName;

    /** 身分證號 */
    @Size(max = 10, message = "idNo 長度不得超過 10")
    private String idNo;

    /** 所屬單位代號清單 */
    private List<@Size(max = 10, message = "depNo 長度不得超過 10") String> depNoList;

    /** 職稱清單 */
    private List<@Size(max = 10, message = "position 長度不得超過 10") String> positionList;

    /** 任職狀況清單 */
    private List<@Size(max = 1, message = "status 長度不得超過 1") String> statusList;

}
