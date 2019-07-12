package com.maxam.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanjinlong
 * @date 2019-04-16 11:15
 **/
@Configuration
@MapperScan(basePackages = "com.maxam.dao.mapper")
public class DAOConfig {
}
