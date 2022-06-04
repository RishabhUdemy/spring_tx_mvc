package com.learn.aptx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.learn.aptx.service","com.learn.aptx.controller"})
@Import(PersistanceConfig.class)
@EnableTransactionManagement
public class RootConfig {

}
