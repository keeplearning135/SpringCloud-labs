package org.itstack.eurekazuul;

import org.itstack.eurekazuul.filter.TokenFilter;
import org.itstack.eurekazuul.service.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

//    @Bean
//    public TokenFilter tokenFilter() {
//        return new TokenFilter();
//    }

    @Autowired
    private RefreshRouteService refreshRouteService;
    @Autowired
    private ZuulHandlerMapping zuulHandlerMapping;

    @RequestMapping("api/refresh")
    public String refresh(){
        refreshRouteService.refreshRoute();
        return "success";
    }

    @RequestMapping("api/queryRouteInfo")
    @ResponseBody
    public Map<String, Object> queryRouteInfo(){
        return zuulHandlerMapping.getHandlerMap();
    }

}
