package com.cicat.utils;

import com.cicat.entity.Command;
import com.cicat.service.ICommandRecordService;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by lunagao on 16/7/29.
 */
public class CommadHelper {

    public static Boolean exeCmd(String buildName, String commandStr, String[] envp, ICommandRecordService service, int projectId) {
        Process process;
        Command command = new Command();
        command.setBuildName(buildName);
        command.setDeleted(false);
        command.setProjectId(projectId);
        try {
            process = Runtime.getRuntime().exec(commandStr, envp);
            process.waitFor();
            command.setCommandStr(commandStr);
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            command.setExecTime(timeStamp);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = input.readLine()) != null) {
                stringBuffer.append(line);
            }
            String outputString = stringBuffer.toString();
            outputString = outputString.replace("\t", "<br/>");
            command.setCommandOutput(outputString);
            input.close();
            command.setCommandResult(process.exitValue() == 0);
            service.createCommand(command);
            return command.getCommandResult();
        } catch (Exception ex) {
            command.setCommandResult(false);
            service.createCommand(command);
            ex.printStackTrace();
            System.out.println("error --------------\n" + ex.getMessage());
            return false;
        }
    }
}
