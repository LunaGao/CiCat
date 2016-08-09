package com.cicat.entity.mapper;

import com.cicat.entity.Setting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lunagao on 16/8/8.
 */
public class SettingMapper implements RowMapper<Setting> {

    @Override
    public Setting mapRow(ResultSet resultSet, int i) throws SQLException {
        Setting setting = new Setting();
        setting.setIdSetting(resultSet.getInt("idSetting"));
        setting.setSettingKey(resultSet.getString("settingKey"));
        setting.setSettingValue(resultSet.getString("settingValue"));
        return setting;
    }

}
