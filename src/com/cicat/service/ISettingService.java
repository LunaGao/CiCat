package com.cicat.service;

import com.cicat.entity.Setting;

import java.util.List;

/**
 * Created by lunagao on 16/8/8.
 */
public interface ISettingService {

    void setSettings(List<Setting> list);
    List<Setting> getSettings();
    Setting getSetting(String key);

}
