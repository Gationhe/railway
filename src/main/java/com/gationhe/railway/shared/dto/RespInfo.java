package com.gationhe.railway.shared.dto;

import java.io.Serializable;

import com.gationhe.railway.shared.enums.ReturnCodeAndDescEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private String returnCode;

    private String returnDesc;

    private String returnMsg;

    public static RespInfo successRespInfo() {
        return new RespInfo(true, ReturnCodeAndDescEnum.SUCCESS.getCode(), ReturnCodeAndDescEnum.SUCCESS.getDesc(),
                null);
    }

}
