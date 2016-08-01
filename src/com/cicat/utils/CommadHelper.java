package com.cicat.utils;

import java.io.*;

/**
 * Created by lunagao on 16/7/29.
 */
public class CommadHelper {

    public static Boolean exeCmd(String commandStr) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commandStr);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error --------------");
            System.out.println(e.getMessage());
        }
        try {
            return process.exitValue() == 0;
        } catch (Exception ex) {
            return false;
        }
    }
}
