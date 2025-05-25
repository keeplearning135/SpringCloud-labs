package com.keeplearning135.nacos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@NacosConfigurationProperties(prefix = "order", dataId = "${nacos.config.data-id}", type = ConfigType.YAML)
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

    private Integer payTimeoutSeconds;

    private Integer createFrequencySeconds;

    public Integer getPayTimeoutSeconds() {
        return payTimeoutSeconds;
    }

    public OrderProperties setPayTimeoutSeconds(Integer payTimeoutSeconds) {
        this.payTimeoutSeconds = payTimeoutSeconds;
        return this;
    }

    public Integer getCreateFrequencySeconds() {
        return createFrequencySeconds;
    }

    public OrderProperties setCreateFrequencySeconds(Integer createFrequencySeconds) {
        this.createFrequencySeconds = createFrequencySeconds;
        return this;
    }
}
