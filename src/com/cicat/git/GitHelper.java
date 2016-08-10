package com.cicat.git;

import com.cicat.entity.Project;
import com.cicat.entity.Setting;
import com.cicat.service.ICommandRecordService;
import com.cicat.utils.CommadHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunagao on 16/7/29.
 */
public class GitHelper {

    ICommandRecordService service;

    private static String BUILD_NAME = "Git Clone";

    public GitHelper(ICommandRecordService service) {
        this.service = service;
    }

    public void cloneProject(Project project, Setting projectLocationSetting, Setting gitLocalPathSettign) throws Exception {
        String project_save_location = projectLocationSetting.getSettingValue();
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
        String commandStr = "cd " + gitLocalPathSettign.getSettingValue() + " && git clone "
                + project.getGit_url() + " "
                + folder.toString() + File.separator + "code";
        Boolean command = CommadHelper.exeCmd(BUILD_NAME, commandStr, service, project.getIdProject());
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
