package com.sizu.jxcpay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="alipay")
@PropertySource(value = {"classpath:/alipay.properties"})
@Data
public class PayConfig {

    private String url;

    private String appid;

    private String privateKey;


    private String publicKey;

    private String appCertPath;

    private String alipayCertPath;


    private String alipayRootCertPath;

    private String callBackUrl;


}
