package com.cicat.service.impl;

import com.cicat.entity.Setting;
import com.cicat.entity.mapper.SettingMapper;
import com.cicat.service.ISettingService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lunagao on 16/8/8.
 */
@Service
public class SettingServiceImpl implements ISettingService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setSettings(List<Setting> list) {
        List<Setting> settings = getSettings();
        for (Setting setting : settings) {
            for (int i = list.size() - 1 ; i >= 0; i --) {
                if (setting.getKey().equals(list.get(i).getKey())) {
                    updateSetting(list.get(i));
                    list.remove(i);
                    break;
                }
            }
        }
        for (Setting setting : list) {
            createSetting(setting);
        }
    }

    @Override
    public List<Setting> getSettings() {
        // TODO: 16/7/26 *改为字段名
        String SQL = "SELECT * FROM Setting";
        return jdbcTemplate.query(SQL,
                new SettingMapper());
    }

    @Override
    public Setting getSetting(String key) {
        String SQL = "SELECT * FROM Setting WHERE settingKey = ?";

        List<Setting> settings  = jdbcTemplate.query(SQL, new Object[]{key},
                new BeanPropertyRowMapper<>(Setting.class));
        if (settings != null && settings.size() >= 1) {
            return settings.get(0);
        } else {
            return null;
        }
    }

    private void updateSetting(Setting setting) {
        String SQL = "UPDATE Setting SET settingValue = ? WHERE settingKey = ?";
        jdbcTemplate.update(SQL, new Object[]{
                setting.getValue(),
                setting.getKey()
                });
    }

    private void createSetting(Setting setting) {
        String SQL = "INSERT INTO Setting (settingKey, settingValue) VALUES ( ? , ? )";
        jdbcTemplate.update( SQL, setting.getKey(), setting.getValue());
    }
}
