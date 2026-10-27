package com.gationhe.railway.internal.infrastructure.mapper;

import java.sql.Date;
import java.time.LocalDate;

import com.gationhe.railway.internal.domain.aggregate.EmpProfileAggregate;
import com.gationhe.railway.internal.infrastructure.persistance.EmpProfilePO;
import com.gationhe.railway.shared.exception.DataMappingException;

public final class EmpProfileMapper {

    public static EmpProfilePO toPO(EmpProfileAggregate aggregate) {
        if (aggregate == null) {
            return null;
        }
        try {
            EmpProfilePO po = new EmpProfilePO();
            po.setEmpId(aggregate.getEmpId());
            po.setName(aggregate.getName());
            po.setEnglishName(aggregate.getEnglishName());
            po.setIdNo(aggregate.getIdNo());
            po.setBirthday(toSqlDate(aggregate.getBirthday()));
            po.setPhone(aggregate.getPhone());
            po.setTel(aggregate.getTel());
            po.setEmergencyContact(aggregate.getEmergencyContact());
            po.setDepNo(aggregate.getDepNo());
            po.setPosition(aggregate.getPosition());
            po.setEmploymentDate(toSqlDate(aggregate.getEmploymentDate()));
            po.setTerminationDate(toSqlDate(aggregate.getTerminationDate()));
            po.setStatus(aggregate.getStatus());
            po.setUpdatedBy(aggregate.getUpdatedBy());
            po.setUpdatedAt(aggregate.getUpdatedAt());
            return po;
        } catch (RuntimeException e) {
            throw new DataMappingException("轉換員工基本資料至持久化物件失敗", e);
        }
    }

    public static EmpProfileAggregate toAggregate(EmpProfilePO po) {
        if (po == null) {
            return null;
        }
        try {
            return EmpProfileAggregate.restore(
                    po.getEmpId(),
                    po.getName(),
                    po.getEnglishName(),
                    po.getIdNo(),
                    toLocalDate(po.getBirthday()),
                    po.getPhone(),
                    po.getTel(),
                    po.getEmergencyContact(),
                    po.getDepNo(),
                    po.getPosition(),
                    toLocalDate(po.getEmploymentDate()),
                    toLocalDate(po.getTerminationDate()),
                    po.getStatus(),
                    po.getUpdatedBy(),
                    po.getUpdatedAt());
        } catch (RuntimeException e) {
            throw new DataMappingException("轉換持久化物件至員工基本資料失敗", e);
        }
    }

    private static Date toSqlDate(LocalDate date) {
        return date == null ? null : Date.valueOf(date);
    }

    private static LocalDate toLocalDate(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
