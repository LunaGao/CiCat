package com.cicat.utils;

import org.jetbrains.annotations.Nullable;

/**
 * Created by lunagao on 16/7/28.
 */
public class CommonString {
    public static String COOKIE_BREAK_CHAR = "|";
    public static String COOKIE_BREAK_SPLIT_CHAR = "\\" + COOKIE_BREAK_CHAR;

    public static String KEY_PORJECT_SAVE_LOCATION = "project_save_location";
    public static String KEY_GIT_LOCATION_PATH = "git_path";

    public static Boolean isEmptyString(@Nullable String string) {
        if (string == null || "".equals(string) || string.isEmpty()) {
            return true;
        }
        return false;
    }
}
