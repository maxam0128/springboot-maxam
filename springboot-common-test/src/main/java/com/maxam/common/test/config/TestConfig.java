package com.maxam.common.test.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author fanjinlong
 * @date 2019-04-15 16:00
 **/
@SpringBootApplication(scanBasePackages = "com.maxam")
@PropertySource(value = {"db.properties"})
public class TestConfig {
}
