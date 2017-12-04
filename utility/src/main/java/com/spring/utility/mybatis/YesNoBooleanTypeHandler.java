package com.spring.utility.mybatis;


import com.spring.utility.CommonUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedJdbcTypes({JdbcType.CHAR, JdbcType.VARCHAR})
@MappedTypes({Boolean.class, boolean.class})
public class YesNoBooleanTypeHandler extends BaseTypeHandler<Boolean> {

    private static final String YES = "Y";
    private static final String NO = "N";


    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        setNonNullParameter(ps, i, CommonUtils.ifBlank(parameter, Boolean.FALSE), jdbcType);
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        boolean b = parameter.booleanValue();
        ps.setString(i, b ? YES : NO);
    }


    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convertStringToBooelan(rs.getString(columnName));
    }


    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convertStringToBooelan(rs.getString(columnIndex));
    }


    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convertStringToBooelan(cs.getString(columnIndex));
    }


    private Boolean convertStringToBooelan(String strValue) throws SQLException {
        if (YES.equalsIgnoreCase(strValue)) {
            return Boolean.TRUE;
        } else if (NO.equalsIgnoreCase(strValue)) {
            return Boolean.FALSE;
        } else {
            return null;
        }
    }

}
