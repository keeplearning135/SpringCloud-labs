package com.keeplearning135.nacos.sentinel.demo.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configuration
public class SentinelConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @Bean
    public NacosDataSource nacosDataSource(ObjectMapper objectMapper) {
        String serverAddress = "127.0.0.1:8848";
        String namespace = "";
        String dataId = "demo-application-flow-rule";
//        String dataId = "example-sentinel";
        String group = "DEFAULT_GROUP";

        // 创建 NacosDataSource 对象
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, serverAddress);
        properties.setProperty(PropertyKeyConst.NAMESPACE, namespace);
        NacosDataSource<List<FlowRule>> nacosDataSource = new NacosDataSource<>(properties, group, dataId,
                new Converter<String, List<FlowRule>>() {
                    @Override
                    public List<FlowRule> convert(String value) {
                        try {
                            return Arrays.asList(objectMapper.readValue(value, FlowRule[].class));
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

        FlowRuleManager.register2Property(nacosDataSource.getProperty());
        return nacosDataSource;
    }

}
