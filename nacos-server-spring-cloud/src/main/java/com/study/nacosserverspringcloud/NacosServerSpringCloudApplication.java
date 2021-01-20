package com.study.nacosserverspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
public class NacosServerSpringCloudApplication {

    @Resource
    private ConfigBean configBean;

    public static void main(String[] args) {
        SpringApplication.run(NacosServerSpringCloudApplication.class, args);
    }

    @RestController
    class EchoController {
        @RequestMapping(value = "/server/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string + " 当前版本：" + configBean.getVersion();
        }
    }

}
