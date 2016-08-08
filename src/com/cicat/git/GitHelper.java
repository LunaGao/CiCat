package com.cicat.git;

import com.cicat.entity.Project;
import com.cicat.entity.Setting;
import com.cicat.utils.CommadHelper;

import java.io.File;

/**
 * Created by lunagao on 16/7/29.
 */
public class GitHelper {

    public void cloneProject(Project project, Setting setting) {
        String project_save_location = setting.getValue();
        File rootDir = File.listRoots()[0];
        String[] path = project_save_location.split(File.separator);

        File folder = getFolders(rootDir, path, 0);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("mkdirs " + folder.mkdirs());
        }
        String commandStr = "cd /User/lunagao/CiCat/\npwd\n";
        Boolean command = CommadHelper.exeCmd(commandStr);
        System.out.println(command);
    }

    public File getFolders(File folder, String[] path, int index) {
        if (index == path.length - 1) {
            return new File(folder, path[index]);
        }
        File file = getFolders(folder, path, index + 1);
        return new File(file, path[index]);
    }

}
