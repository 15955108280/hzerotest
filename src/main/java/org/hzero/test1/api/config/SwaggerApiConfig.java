package org.hzero.test1.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerApiConfig {
    public static final String RFX = "rfx";
    public static final String HEADER = "Header";
    public static final String  LINEITEM= "LineItem";



    @Autowired
    public SwaggerApiConfig(Docket docket) {
        docket.tags(
                new Tag(RFX, "询价单"),
                new Tag(HEADER, "询价单单头"),
                new Tag(LINEITEM, "询价单物料")
        );
    }
}
