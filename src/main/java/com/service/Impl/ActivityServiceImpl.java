package com.service.Impl;

import com.service.ActivityService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Override
    public List<Deployment> getdeplist() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        return list;
    }

    @Override
    public int add(InputStream in, String name) {
        ZipInputStream zip = new ZipInputStream(in);
        Deployment deploy = repositoryService.createDeployment().addZipInputStream(zip).name(name).deploy();
        if (deploy!=null){
            return 1;
        }else {
            return 0;
        }
    }

/*
   获得流程定义列表
*/
    @Override
    public List<ProcessDefinition> getprolist() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        return list;
    }

    @Override
    public InputStream findimage(String depid, String imagename) {
        return   repositoryService.getResourceAsStream(depid,imagename);
    }

    @Override
    public int deletedeploy(String depid) {
        repositoryService.deleteDeployment(depid);
        return 1;
    }

    @Override
    public int qingjia(int leaveid, String username) {
        return 0;
    }
}
