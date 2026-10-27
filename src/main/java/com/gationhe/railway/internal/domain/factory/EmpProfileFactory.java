package com.gationhe.railway.internal.domain.factory;

import java.time.Year;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gationhe.railway.internal.domain.repository.EmpProfileRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpProfileFactory {

    private final EmpProfileRepository empProfileRepository;

    /**
     * 取得可用的員工編號
     * <p>
     * 根據目前西元年份產生新的員工編號，格式為 E + 西元年 + 四位流水號。
     * 使用 PostgreSQL advisory lock 確保在交易中產生的員工編號不會重複。
     * </p>
     * 
     * @return 可用的員工編號
     */
    public String getAvailableEmpId() {
        // 取得目前西元年
        String year = String.valueOf(Year.now().getValue());
        // 向 PostgreSQL 申請一把交易級 advisory lock
        empProfileRepository.lockEmpIdGeneration(year);
        // 取得目前 Table 最新的員工編號
        String latestEmpId = empProfileRepository.getLatestEmpId(year);
        // 回傳新增員工基本資料要用的員工編號
        return "E" + year + (StringUtils.isBlank(latestEmpId) ? "0001"
                : String.format("%04d", Integer.parseInt(latestEmpId.substring(latestEmpId.length() - 4)) + 1));
    }

}
