package com.gationhe.railway.shared.enums;

public enum ReturnCodeAndDescEnum {

    SUCCESS("0000", "交易成功"),
    INVALID_INPUT("A001", "輸入欄位不正確"),
    APP_FAIL("AP01", "應用層異常"),
    DATA_NOT_FOUND("AP02", "查無資料"),
    DELETE_FAIL("AP03", "刪除失敗"),
    DOMAIN_FAIL("D001", "領域層異常"),
    INFRA_FAIL("I001", "基礎設施層異常"),
    SQL_FAIL("I002", "取得 SQL 查詢異常"),
    REFLECTION_FAIL("I003", "資料映射異常"),
    OTHER_FAIL("9999", "其他系統異常");

    private String code;

    private String desc;

    private ReturnCodeAndDescEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
