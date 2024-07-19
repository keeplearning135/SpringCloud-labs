package com.keeplearning135.zookeeper.service;

import org.springframework.web.bind.annotation.PathVariable;


public interface ITestService {

    String get(String path);

    String put(String path,String msg);

    String update(String path,String msg);
}
