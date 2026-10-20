package com.gationhe.railway.shared.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resp<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private RespInfo respInfo;

    private T tranrs;

}
