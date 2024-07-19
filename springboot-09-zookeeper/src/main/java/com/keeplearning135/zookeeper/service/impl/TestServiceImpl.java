package com.keeplearning135.zookeeper.service.impl;

import com.keeplearning135.zookeeper.config.WatcherApi;
import com.keeplearning135.zookeeper.config.ZkApi;
import com.keeplearning135.zookeeper.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private ZkApi zkApi;


    @Override
    public String get(String path) {
        return zkApi.getData("/"+path,new WatcherApi());
    }


    @Override
    public String put(String path, String msg) {
        zkApi.createNode("/"+path,msg);
        return msg;
    }


    @Override
    public String update(String path, String msg) {
        zkApi.updateNode("/"+path,msg);
        return msg;
    }
}
