package com.keeplearning135.zookeeper.controller;

import com.keeplearning135.zookeeper.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping("get/{path}")
    public String get(@PathVariable("path") String path){
        return testService.get(path);
    }

    @GetMapping("put/{path}/{msg}")
    public String put(@PathVariable("path") String path, @PathVariable("msg") String msg){
        return testService.put(path,msg);
    }

    @GetMapping("up/{path}/{msg}")
    public String update(@PathVariable("path") String path, @PathVariable("msg") String msg){
        return testService.update(path,msg);
    }
}
