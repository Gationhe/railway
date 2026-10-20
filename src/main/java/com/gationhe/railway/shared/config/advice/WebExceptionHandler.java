package com.gationhe.railway.shared.config.advice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gationhe.railway.shared.dto.Resp;
import com.gationhe.railway.shared.dto.RespInfo;
import com.gationhe.railway.shared.enums.ReturnCodeAndDescEnum;
import com.gationhe.railway.shared.exception.ApplicationException;
import com.gationhe.railway.shared.exception.DataMappingException;
import com.gationhe.railway.shared.exception.DataNotFoundException;
import com.gationhe.railway.shared.exception.DeleteFailException;
import com.gationhe.railway.shared.exception.DomainException;
import com.gationhe.railway.shared.exception.GetSqlFailException;
import com.gationhe.railway.shared.exception.InfrastructureException;
import com.gationhe.railway.shared.exception.InvalidInputException;

/**
 * 全域例外處理器（Controller Advice）
 */
@ControllerAdvice
public class WebExceptionHandler {

    /**
     * 處理輸入值不正確的例外（{@link InvalidInputException}）
     *
     * @param e 輸入驗證例外
     * @return 回應碼為 INVALID_INPUT(A001) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleInvalidInputException(InvalidInputException e) {
        return buildResp(ReturnCodeAndDescEnum.INVALID_INPUT, e);
    }

    /**
     * 處理應用層例外（{@link ApplicationException}）
     *
     * @param e 應用層例外
     * @return 回應碼為 APP_FAIL(AP01) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleApplicationException(ApplicationException e) {
        return buildResp(ReturnCodeAndDescEnum.APP_FAIL, e);
    }

    /**
     * 處理查無資料的例外（{@link DataNotFoundException}）
     *
     * @param e 查無資料例外
     * @return 回應碼為 DATA_NOT_FOUND(AP02) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleDataNotFoundException(DataNotFoundException e) {
        return buildResp(ReturnCodeAndDescEnum.DATA_NOT_FOUND, e);
    }

    /**
     * 處理刪除失敗的例外（{@link DeleteFailException}）
     *
     * @param e 刪除失敗例外
     * @return 回應碼為 DELETE_FAIL(AP03) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(DeleteFailException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleDeleteFailException(DeleteFailException e) {
        return buildResp(ReturnCodeAndDescEnum.DELETE_FAIL, e);
    }

    /**
     * 處理領域層例外（{@link DomainException}）
     *
     * @param e 領域層例外
     * @return 回應碼為 DOMAIN_FAIL(D001) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleDomainException(DomainException e) {
        return buildResp(ReturnCodeAndDescEnum.DOMAIN_FAIL, e);
    }

    /**
     * 處理基礎設施層例外（{@link InfrastructureException}）
     *
     * @param e 基礎設施層例外
     * @return 回應碼為 INFRA_FAIL(I001) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(InfrastructureException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleInfrastructureException(InfrastructureException e) {
        return buildResp(ReturnCodeAndDescEnum.INFRA_FAIL, e);
    }

    /**
     * 處理取得 SQL 查詢失敗的例外（{@link GetSqlFailException}）
     *
     * @param e 取得 SQL 查詢失敗例外
     * @return 回應碼為 SQL_FAIL(I002) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(GetSqlFailException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleGetSqlFailException(GetSqlFailException e) {
        return buildResp(ReturnCodeAndDescEnum.SQL_FAIL, e);
    }

    /**
     * 處理資料映射失敗的例外（{@link DataMappingException}）
     *
     * @param e 資料映射失敗例外
     * @return 回應碼為 REFLECTION_FAIL(I003) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(DataMappingException.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleDataMappingException(DataMappingException e) {
        return buildResp(ReturnCodeAndDescEnum.REFLECTION_FAIL, e);
    }

    /**
     * 通用例外處理：攔截所有未被上述方法明確處理的例外（{@link Exception}）
     *
     * @param e 任何未明確處理的例外
     * @return 回應碼為 OTHER_FAIL(9999) 的 {@link Resp} 物件
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Resp<Object> handleException(Exception e) {
        return buildResp(ReturnCodeAndDescEnum.OTHER_FAIL, e);
    }

    /**
     * 建立統一格式的 {@link Resp} 回應物件
     * <p>
     * 若例外訊息為空白，則以回應碼描述（{@code codeEnum.getDesc()}）作為回傳訊息。
     *
     * @param codeEnum 回應碼與描述的列舉
     * @param e        發生的例外
     * @return 統一格式的 {@link Resp} 物件
     */
    private Resp<Object> buildResp(ReturnCodeAndDescEnum codeEnum, Exception e) {
        return new Resp<>(new RespInfo(false, codeEnum.getCode(), codeEnum.getDesc(),
                StringUtils.defaultIfBlank(e.getMessage(), codeEnum.getDesc())), null);
    }

}
