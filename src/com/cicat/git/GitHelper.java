package com.cicat.git;

import com.cicat.entity.Project;
import com.cicat.utils.CommadHelper;

import java.io.File;

/**
 * Created by lunagao on 16/7/29.
 */
public class GitHelper {

    public static void cloneProject(Project project) {
        File rootDir = File.listRoots()[0];
        File folder = new File(new File(new File(rootDir, "Users"), "lunagao"), "CiCat");// new File("User/lunagao/CiCat/project");
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("mkdirs " + folder.mkdirs());
        }
        String commandStr = "cd /User/lunagao/CiCat/\npwd\n";
        Boolean command = CommadHelper.exeCmd(commandStr);
        System.out.println(command);
    }

}
