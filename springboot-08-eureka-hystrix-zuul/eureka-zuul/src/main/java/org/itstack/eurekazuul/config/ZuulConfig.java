package org.itstack.eurekazuul.config;

import org.itstack.eurekazuul.router.RouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;
    @Autowired
    private ServerProperties server;

    @Bean
    public RouteLocator routeLocator() {
        return new RouteLocator(this.server.getServlet().getPath(), this.zuulProperties);
    }

}
