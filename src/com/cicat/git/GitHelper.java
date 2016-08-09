package com.cicat.git;

import com.cicat.entity.Project;
import com.cicat.entity.Setting;
import com.cicat.utils.CommadHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunagao on 16/7/29.
 */
public class GitHelper {

    public void cloneProject(Project project, Setting setting) throws Exception {
        String project_save_location = setting.getSettingValue();
        File rootDir = File.listRoots()[0];
        String[] path = project_save_location.split(File.separator);
        List<String> paths = new ArrayList<>();
        for (String p : path) {
            if (!p.equals("")) {
                paths.add(p);
            }
        }
        paths.add(project.getPlatform());
        paths.add(project.getName());

        File folder = getFolders(rootDir, paths, paths.size() - 1);

        if (!folder.exists() || !folder.isDirectory()) {
            if (!folder.mkdirs()) {
                throw new Exception("\"Project Location\" path can not be create, please check it again.");
            }
        }
        String commandStr = "cd /Users/lunagao/CiCat/\npwd\n";
        Boolean command = CommadHelper.exeCmd(commandStr);
        System.out.println(command);
    }

    private File getFolders(File folder, List<String> path, int index) {
        if (index == 0) {
            return new File(folder, path.get(index));
        }
        File file = getFolders(folder, path, index - 1);
        return new File(file, path.get(index));
    }

}
