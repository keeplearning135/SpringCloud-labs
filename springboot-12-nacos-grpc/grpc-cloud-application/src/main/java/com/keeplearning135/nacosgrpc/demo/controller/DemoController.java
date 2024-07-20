package com.keeplearning135.nacosgrpc.demo.controller;

import com.keeplearning135.nacosgrpc.userservice.api.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userServiceGrpc;

    @GetMapping("/get")
    public String get(@RequestParam("id") Integer id) {
        UserGetRequest request = UserGetRequest.newBuilder().setId(id).build();
        UserGetResponse response = userServiceGrpc.get(request);
        return response.getName();
    }

    @GetMapping("/create")
    public Integer create(@RequestParam("name") String name,
                          @RequestParam("gender") Integer gender) {
        UserCreateRequest request = UserCreateRequest.newBuilder()
                .setName(name).setGender(gender).build();
        UserCreateResponse response = userServiceGrpc.create(request);
        return response.getId();
    }
}
